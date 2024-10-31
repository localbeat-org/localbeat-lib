package org.localbeat.api.gis.google;

import com.fasterxml.jackson.annotation.JsonProperty;

/****************************************************************************
 * <b>Title:</b> TypePart.java <br>
 * <b>Project:</b> api <br>
 * <b>Description:</b> --- Change Me -- <br>
 * <b>Copyright:</b> Copyright (c) 2024 <br>
 * <b>Company:</b> Localbeat
 * 
 * @author etewa
 * @version 1.x
 * @since May 5, 2024
 * <b>updates:</b>
 * 
 ****************************************************************************/

public enum TypePart {
	@JsonProperty("street_address")
	STREET_ADDRESS,
	
	@JsonProperty("route")
	ROUTE, 
	
	@JsonProperty("intersection")
	INTERSECTION,
	
	@JsonProperty("political")
	POLITICAL,
	
	@JsonProperty("country")
	COUNTRY,
	
	@JsonProperty("administrative_area_level_1")
	ADMINISTRATIVE_AREA_LEVEL_1,
	
	@JsonProperty("administrative_area_level_2")
	ADMINISTRATIVE_AREA_LEVEL_2,
	
	@JsonProperty("administrative_area_level_3")
	ADMINISTRATIVE_AREA_LEVEL_3,
	
	@JsonProperty("administrative_area_level_4")
	ADMINISTRATIVE_AREA_LEVEL_4,
	
	@JsonProperty("administrative_area_level_5")
	ADMINISTRATIVE_AREA_LEVEL_5,
	
	@JsonProperty("administrative_area_level_6")
	ADMINISTRATIVE_AREA_LEVEL_6,
	
	@JsonProperty("administrative_area_level_7")
	ADMINISTRATIVE_AREA_LEVEL_7,
	
	@JsonProperty("colloquial_area")
	COLLOQUIAL_AREA,
	
	@JsonProperty("locality")
	LOCALITY,
	
	@JsonProperty("sublocality")
	SUBLOCALITY,
	
	@JsonProperty("sublocality_level_5")
	SUBLOCALITY_LEVEL_5,
	
	@JsonProperty("neighborhood")
	NEIGHBORHOOD,
	
	@JsonProperty("premise")
	PREMISE,
	
	@JsonProperty("subpremise")
	SUBPREMISE,
	
	@JsonProperty("plus_code")
	PLUS_CODE,
	
	@JsonProperty("postal_code")
	POSTAL_CODE,
	
	@JsonProperty("natural_feature")
	NATURAL_FEATURE,
	
	@JsonProperty("airport")
	AIRPORT,
	
	@JsonProperty("park")
	PARK,
	
	@JsonProperty("point_of_interest")
	POINT_OF_INTEREST, 
	
	@JsonProperty("street_number")
	STREET_NUMBER, 
	
	@JsonProperty("postal_code_suffix")
	POSTAL_CODE_SUFFIX
}
