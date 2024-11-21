package org.localbeat.api.geo;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/****************************************************************************
 * <b>Title:</b> BoundingBox.java <br>
 * <b>Project:</b> Entertainment <br>
 * <b>Description:</b> A bean to hold the max and min coordinates of the bounding box <br>
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
public class BoundingBox {

	/**
	 * Bottom left coordinate of the bounding box
	 */
	@JsonProperty(value="southwest")
	private Coordinate minPoint;
	
	/**
	 * Top right of the bounding box
	 */
	@JsonProperty(value="northeast")
	private Coordinate maxPoint;
	
	/**
	 * Returns the smallest value of the latitudes.  This is due to the fact that
	 * there can be negative numbers
	 * @return
	 */
	public double getMinimumLatitudeValue() {
		
		return minPoint.getLatitude() < maxPoint.getLatitude() ? minPoint.getLatitude() : maxPoint.getLatitude();
	}
	
	/**
	 * Returns the smallest value of the latitudes.  This is due to the fact that
	 * there can be negative numbers
	 * @return
	 */
	public double getMinimumLongitudeValue() {
		
		return minPoint.getLongitude() < maxPoint.getLongitude() ? minPoint.getLongitude() : maxPoint.getLongitude();
	}
	
	/**
	 * Returns the smallest value of the latitudes.  This is due to the fact that
	 * there can be negative numbers
	 * @return
	 */
	public double getMaximumLatitudeValue() {
		
		return minPoint.getLatitude() > maxPoint.getLatitude() ? minPoint.getLatitude() : maxPoint.getLatitude();
	}
	
	/**
	 * Returns the smallest value of the latitudes.  This is due to the fact that
	 * there can be negative numbers
	 * @return
	 */
	public double getMaximumLongitudeValue() {
		
		return minPoint.getLongitude() > maxPoint.getLongitude() ? minPoint.getLongitude() : maxPoint.getLongitude();
	}
}
