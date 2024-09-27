package org.localbeat.api.gis.data;

import org.localbeat.api.gis.util.GeocodeParseException;
import org.localbeat.api.gis.util.GeocoderConfigDTO;
import org.springframework.stereotype.Component;

/****************************************************************************
 * <b>Title:</b> AbstractGeocoder.java <br>
 * <b>Project:</b> _Sandbox <br>
 * <b>Description:</b> --- Change Me -- <br>
 * <b>Copyright:</b> Copyright (c) 2024 <br>
 * <b>Company:</b> Localbeat
 * 
 * @author etewa
 * @version 1.x
 * @since Apr 1, 2024
 * <b>updates:</b>
 * 
 ****************************************************************************/
@Component
public abstract class AbstractGeocoder {
	
	protected GeocoderConfigDTO config;

	protected AbstractGeocoder(GeocoderConfigDTO config) {
		this.config = config;
	}
	
	/**
	 * 
	 * @param json
	 * @return
	 * @throws GeocodeParseException
	 */
	public abstract GeolocationDTO geocode(LocationDTO loc) throws GeocodeParseException;

	/*
	 * 
	 */
	@Override
	public String toString() {
		return "Geocoder Instance: " + config;
	}
}

