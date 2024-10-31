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
		double latitude = 39.86336900;
		double longitude = -105.17242900;
		
		BoundingBox box = new DistanceUtil().getBoundingBox(new Coordinate(latitude, longitude), 10);
		
		// Validate the min point
		assertEquals(39.71860074610647, box.getMinPoint().getLatitude());
		assertEquals(-105.36103367858658, box.getMinPoint().getLongitude());
		
		// Validate the max point
		assertEquals(40.00813725389353, box.getMaxPoint().getLatitude());
		assertEquals(-104.9838243214134, box.getMaxPoint().getLongitude());
	}

	/**
	 * Test method for {@link org.localbeat.api.geo.DistanceUtil#getDistanceBetweenPoints(org.localbeat.api.geo.Coordinate, org.localbeat.api.geo.Coordinate)}.
	 */
	@Test
	void testGetDistanceBetweenPoints() {
		Coordinate middle = new Coordinate(39.86336900, -105.17242900);
		BoundingBox box = new DistanceUtil().getBoundingBox(middle, 5.33);
		
		Coordinate start = box.getMinPoint();
		Coordinate end = new Coordinate(box.getMinimumLatitudeValue(), box.getMaximumLongitudeValue());
		
		double distance = new DistanceUtil().getDistanceBetweenPoints(start, end);
		
		assertEquals(10.67, distance);
	}

}
