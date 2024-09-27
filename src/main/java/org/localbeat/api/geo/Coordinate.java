package org.localbeat.api.geo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/****************************************************************************
 * <b>Title:</b> Point.java <br>
 * <b>Project:</b> Entertainment <br>
 * <b>Description:</b> Class to hold a latitude and longitude coordinate <br>
 * <b>Copyright:</b> Copyright (c) 2023 <br>
 * <b>Company:</b> Local Beats
 * 
 * @author etewa
 * @version 1.x
 * @since Mar 27, 2024
 * <b>updates:</b>
 * 
 ****************************************************************************/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Coordinate implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * Latitude of the point
	 */
	@JsonProperty(value="lat")
	private double latitude;
	
	/**
	 * Longitude of the point
	 */
	@JsonProperty(value="lng")
	private double longitude;
	
	
	public boolean hasCoodinate() {
		return latitude > 0 || latitude < 0;
	}
}
