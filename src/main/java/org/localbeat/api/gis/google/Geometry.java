package org.localbeat.api.gis.google;

import org.localbeat.api.geo.BoundingBox;
import org.localbeat.api.geo.Coordinate;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/****************************************************************************
 * <b>Title:</b> Geometry.java <br>
 * <b>Project:</b> api <br>
 * <b>Description:</b> Holds a set of coordinates for a geometry shape <br>
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
class Geometry {
	
	private Coordinate location;
	
	@JsonProperty(value = "location_type")
	private String locationType;
	
	
	private BoundingBox viewport;
	
	private BoundingBox bounds;
	
}

