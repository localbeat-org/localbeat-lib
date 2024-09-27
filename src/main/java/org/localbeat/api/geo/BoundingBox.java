package org.localbeat.api.geo;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/****************************************************************************
 * <b>Title:</b> BoundingBox.java <br>
 * <b>Project:</b> Entertainment <br>
 * <b>Description:</b> --- Change Me --- <br>
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
	 * Top left coordinate of the bounding box
	 */
	@JsonProperty(value="southwest")
	private Coordinate minPoint;
	
	/**
	 * Bottom right of the bounding box
	 */
	@JsonProperty(value="northeast")
	private Coordinate maxPoint;
}
