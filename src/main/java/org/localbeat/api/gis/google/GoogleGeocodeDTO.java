package org.localbeat.api.gis.google;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.localbeat.api.gis.data.GeolocationDTO;
import org.localbeat.api.gis.data.GeolocationDTO.MatchCode;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.siliconmtn.data.text.StringUtil;
import lombok.Data;

/****************************************************************************
 * <b>Title:</b> GoogleGeocodeDTO.java <br>
 * <b>Project:</b> api <br>
 * <b>Description:</b> DTO to map the google geocoding API response into a java object <br>
 * <b>Copyright:</b> Copyright (c) 2024 <br>
 * <b>Company:</b> Localbeat
 * 
 * @author etewa
 * @version 1.x
 * @since Apr 1, 2024
 * <b>updates:</b>
 * 
 ****************************************************************************/
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GoogleGeocodeDTO {
	
	/**
	 * Match codes received from the json response.  Note that these values are 
	 * from the location type field
	 */
	public enum LocationType {
		APPROXIMATE, GEOMETRIC_CENTER, RANGE_INTERPOLATED, ROOFTOP
	}

	/**
	 * Status code of the response.
	 */
	public enum StatusCode {
		OK, OVER_DAILY_LIMIT, ZERO_RESULTS, OVER_QUERY_LIMIT, REQUEST_DENIED, 
		INVALID_REQUEST, UNKNOWN_ERROR
	}
	
	// Members
	private List<Address> results = new ArrayList<>();
	private StatusCode status;
	private String streetNumber;
	private String route;
	private MatchCode matchCode;
	protected Map<String, MatchCode> matchCodeMapper = new LinkedHashMap<>();
	
	public GoogleGeocodeDTO() {
		matchCodeMapper.put("getAddress", MatchCode.ADDRESS);
		matchCodeMapper.put("getCity", MatchCode.CITY);
		matchCodeMapper.put("getCounty", MatchCode.COUNTY);
		matchCodeMapper.put("getZip", MatchCode.ZIP);
		matchCodeMapper.put("getState", MatchCode.STATE);
		matchCodeMapper.put("getCountry", MatchCode.COUNTRY);
	}
	
	/**
	 * Converts a GoogleGeocodeDTO to a GeolocationDTO
	 * @return
	 */
	public GeolocationDTO getGeolocation() {
		GeolocationDTO loc = new GeolocationDTO();
		String street = getValue(TypePart.STREET_NUMBER);
		String locRoute = getValue(TypePart.ROUTE);
		
		if (!StringUtil.isEmpty(locRoute)) {
			if (StringUtil.isEmpty(street)) matchCode = MatchCode.STREET;
			loc.setAddress((StringUtil.isEmpty(street) ? "" : street + " ") + locRoute );
		}
		
		loc.setCity(getValue(TypePart.LOCALITY));
		loc.setState(getValue(TypePart.ADMINISTRATIVE_AREA_LEVEL_1));
		loc.setZip(getValue(TypePart.POSTAL_CODE));
		loc.setCounty(getValue(TypePart.ADMINISTRATIVE_AREA_LEVEL_2));
		loc.setCountry(getValue(TypePart.COUNTRY));
		loc.setNeighborhood(getValue(TypePart.NEIGHBORHOOD));
		
		if (results != null && !results.isEmpty()) {
			loc.setLatitude(results.get(0).getGeometry().getLocation().getLatitude());
			loc.setLongitude(results.get(0).getGeometry().getLocation().getLongitude());
		}
		assignMatchCode(loc);
		loc.setMatchCode(matchCode);
		return loc;
	}
	
	/**
	 * Assigns Match Code
	 * @param loc
	 */
	protected void assignMatchCode(GeolocationDTO loc) {
		if (matchCode != null) return;
		if (loc.getLatitude() == 0 || loc.getLongitude() == 0) matchCode = MatchCode.NO_MATCH;
		else if (! StringUtil.isEmpty(loc.getAddress())) matchCode = MatchCode.ADDRESS;
		else if (! StringUtil.isEmpty(loc.getZip())) matchCode = MatchCode.ZIP;
		else if (! StringUtil.isEmpty(loc.getCity())) matchCode = MatchCode.CITY;
		else if (! StringUtil.isEmpty(loc.getCounty())) matchCode = MatchCode.COUNTY;
		else if (! StringUtil.isEmpty(loc.getState())) matchCode = MatchCode.STATE;
		else if (! StringUtil.isEmpty(loc.getCountry())) matchCode = MatchCode.COUNTRY;
		else matchCode = MatchCode.NO_MATCH;
	}
	
	/**
	 * Loops the address components to match the address part
	 * @param tp Type to match
	 * @return Value of the matching type
	 */
	protected String getValue(TypePart tp) {
		if (results == null || results.isEmpty()) return null;
		for (AddressType a : results.get(0).getAddressComponents()) {
			if (TypePart.INTERSECTION.equals(a.getTypes().get(0))) matchCode = MatchCode.INTERSECTION;
			if (tp.equals(a.getTypes().get(0))) return a.getShortName();
			
		}
		
		return "";
	}
	
}

