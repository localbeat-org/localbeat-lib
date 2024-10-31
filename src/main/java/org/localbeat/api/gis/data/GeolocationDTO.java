package org.localbeat.api.gis.data;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import com.siliconmtn.data.text.StringUtil;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/****************************************************************************
 * <b>Title:</b> GeolocationDTO.java <br>
 * <b>Project:</b> _Sandbox <br>
 * <b>Description:</b> Extends the location class with gis data<br>
 * <b>Copyright:</b> Copyright (c) 2024 <br>
 * <b>Company:</b> Localbeat
 * 
 * @author etewa
 * @version 1.x
 * @since Apr 2, 2024
 * <b>updates:</b>
 * 
 ****************************************************************************/
@Data
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
public class GeolocationDTO extends LocationDTO {
	
	/**
	 * List of enums tracking the different possible geocoding match codes.  The manual
	 * code is not returned from the geocoder, but is used when a lat/long is manually assigned
	 */
	public enum MatchCode {
		
		ADDRESS("Address"), STREET("Street Level Match"), 
		INTERSECTION("Intersection of 2 Roads"), ZIP("Zip Code"),
		CITY("City"), COUNTY("County"), STATE("State"), COUNTRY("Country"),
		NO_MATCH("No Match"), MANUAL("Manually Assigned Geocode");
		
		public String getName() { return name; }
		private String name;
		private MatchCode(String name) {
			this.name = name;
		}
	}

	private String neighborhood;
	private double latitude;
	private double longitude;
	private MatchCode matchCode = MatchCode.NO_MATCH;

	/**
	 * Formats the address pieces into a single, comma delimited string
	 * @return
	 */
	@Override
	public String getFormattedAddress() {
		List<String> vals = Arrays.asList(address, address2, neighborhood, city, county, state, zip, country, latitude+"", longitude+"", matchCode.toString());

		return vals.stream()
                .filter(c -> !StringUtil.isEmpty(c) && !c.equals("0.0"))
                .map(m -> Character.toUpperCase(m.charAt(0)) + m.substring(1))
                .collect(Collectors.joining(", "));
	}
}

