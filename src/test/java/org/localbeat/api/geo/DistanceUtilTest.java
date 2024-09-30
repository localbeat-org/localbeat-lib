package org.localbeat.api.geo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title:</b> DistanceUtilTest.java <br>
 * <b>Project:</b> Entertainment <br>
 * <b>Description:</b> UNit test for the distance utility for bounding boxes <br>
 * <b>Copyright:</b> Copyright (c) 2023 <br>
 * <b>Company:</b> Local Beats
 * 
 * @author etewa
 * @version 1.x
 * @since Mar 27, 2024
 * <b>updates:</b>
 * 
 ****************************************************************************/
class DistanceUtilTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	protected void setUp() throws Exception {
	}

	/**
	 * Test method for {@link org.localbeat.api.geo.DistanceUtil#getBoundingBox(org.localbeat.api.geo.Coordinate, double)}.
	 */
	@Test
	void testGetBoundingBox() {
		double latitude = 39.8232;
		double longitude = -105.2825;
		
		BoundingBox box = new DistanceUtil().getBoundingBox(new Coordinate(latitude, longitude), 10);
		
		// Validate the min point
		assertEquals(39.75081604042454, box.getMinPoint().getLatitude());
		assertEquals(-105.3767469690478, box.getMinPoint().getLongitude());
		
		// Validate the max point
		assertEquals(39.895583959575454, box.getMaxPoint().getLatitude());
		assertEquals(-105.18825303095217, box.getMaxPoint().getLongitude());
	}

}
