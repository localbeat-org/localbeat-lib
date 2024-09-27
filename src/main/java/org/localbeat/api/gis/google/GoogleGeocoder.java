package org.localbeat.api.gis.google;

import java.io.IOException;

import org.localbeat.api.gis.data.AbstractGeocoder;
import org.localbeat.api.gis.data.GeolocationDTO;
import org.localbeat.api.gis.data.LocationDTO;
import org.localbeat.api.gis.util.GeocodeParseException;
import org.localbeat.api.gis.util.GeocoderConfigDTO;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.siliconmtn.data.text.StringUtil;

/****************************************************************************
 * <b>Title:</b> GoogleGeocodeParser.java <br>
 * <b>Project:</b> api <br>
 * <b>Description:</b> Code to perform a geocode against the google pi <br>
 * <b>Copyright:</b> Copyright (c) 2024 <br>
 * <b>Company:</b> Localbeat
 * 
 * @author etewa
 * @version 1.x
 * @since Apr 1, 2024
 * <b>updates:</b>
 * 
 ****************************************************************************/
public class GoogleGeocoder extends AbstractGeocoder {
	
	// Members
	protected RestTemplate rt;
	
	/**
	 * Constructor for autowiring
	 * @param config
	 */
	public GoogleGeocoder(GeocoderConfigDTO config) {
		super(config);
		rt = new RestTemplate();
	}
	
	/**
	 * 
	 * @param json
	 * @return
	 * @throws GeocodeParseException
	 */
	public GeolocationDTO geocode(LocationDTO loc) throws GeocodeParseException {
		if (StringUtil.isEmpty(config.getKey()) || StringUtil.isEmpty(config.getUrl())) 
			throw new GeocodeParseException("Invalid Configuration");
		
		try {
			ObjectMapper om = new ObjectMapper();
			GoogleGeocodeDTO dto = om.readValue(getGeocode(loc), GoogleGeocodeDTO.class);
			return dto.getGeolocation();
			
		} catch (Exception e) {
			throw new GeocodeParseException("Unable to geocode address: " + loc, e );
		}
	}
	
	/** 
	 * Calls out to google to retrieve the geocode
	 * @param loc
	 * @return
	 * @throws IOException
	 */
	protected String getGeocode(LocationDTO loc) {
		String url = config.getUrl().replace("$ADDRESS", loc.getFormattedAddress());
		url = url.replace("$KEY", config.getKey());
		return rt.getForObject(url, String.class);
	}
 
	@Override
	public String toString() {
		return super.toString();
	}
}