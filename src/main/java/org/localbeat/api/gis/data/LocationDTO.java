package org.localbeat.api.gis.data;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Data;
import lombok.NoArgsConstructor;

/****************************************************************************
 * <b>Title:</b> LocationDTO.java <br>
 * <b>Project:</b> entertainment <br>
 * <b>Description:</b> Base location information needed to generate a geocode <br>
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
@NoArgsConstructor
public class LocationDTO {

	protected String address;
	protected String address2;
	protected String city;
	protected String county;
	protected String state;
	protected String country;
	protected String zip;

	/**
	 * Formats the address pieces into a single, comma delimited string
	 * @return
	 */
	public String getFormattedAddress() {
		List<String> vals = Arrays.asList(address, address2, city, county, state, zip, country);

		return vals.stream()
                .filter(c -> c != null)
                .map(m -> Character.toUpperCase(m.charAt(0)) + m.substring(1))
                .collect(Collectors.joining(", "));
	}
}

