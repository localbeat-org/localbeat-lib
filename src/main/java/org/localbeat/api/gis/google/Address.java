package org.localbeat.api.gis.google;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/****************************************************************************
 * <b>Title:</b> Address.java <br>
 * <b>Project:</b> api <br>
 * <b>Description:</b> Google Address info for parsing <br>
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
@JsonIgnoreProperties(ignoreUnknown = true)
class Address {
	
	@JsonProperty(value="formatted_address")
	private String formattedAddress;
	
	@JsonProperty(value = "place_id")
	private String placeId;
	
	@JsonProperty(value = "address_components")
	private List<AddressType> addressComponents;
	
	private List<String> types;
	
	
	private Geometry geometry;
	
	
}

