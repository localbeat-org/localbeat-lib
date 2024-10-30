package org.localbeat.api.geo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title:</b> BoundingBoxTest.java <br>
 * <b>Project:</b> localbeat-lib <br>
 * <b>Description:</b> --- Change Me -- <br>
 * <b>Copyright:</b> Copyright (c) 2024 <br>
 * <b>Company:</b> Localbeat
 * 
 * @author etewa
 * @version 1.x
 * @since Oct 30, 2024
 * <b>updates:</b>
 * 
 ****************************************************************************/

class BoundingBoxTest {
	
	// Members
	BoundingBox box;
	BoundingBox swapBox;
	double startLatitude;
	double startLongitude;
	double endLatitude;
	double endLongitude;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	protected void setUp() throws Exception {

		startLatitude = 39.71860074610647;
		startLongitude = -105.36103367858658;
		
		endLatitude = 40.00813725389353;
		endLongitude = -104.9838243214134;

		box = new BoundingBox(new Coordinate(startLatitude, startLongitude), new Coordinate(endLatitude, endLongitude));
		swapBox = new BoundingBox(new Coordinate(endLatitude, endLongitude), new Coordinate(startLatitude, startLongitude));
	}

	/**
	 * Test method for {@link org.localbeat.api.geo.BoundingBox#getMinimumLatitudeValue()}.
	 */
	@Test
	void testGetMinimumLatitudeValue() {
		assertEquals(startLatitude, box.getMinimumLatitudeValue());
		assertEquals(startLatitude, swapBox.getMinimumLatitudeValue());
	}

	/**
	 * Test method for {@link org.localbeat.api.geo.BoundingBox#getMinimumLongitudeValue()}.
	 */
	@Test
	void testGetMinimumLongitudeValue() {
		assertEquals(startLongitude, box.getMinimumLongitudeValue());
		assertEquals(startLongitude, swapBox.getMinimumLongitudeValue());
	}

	/**
	 * Test method for {@link org.localbeat.api.geo.BoundingBox#getMaximumLatitudeValue()}.
	 */
	@Test
	void testGetMaximumLatitudeValue() {
		assertEquals(endLatitude, box.getMaximumLatitudeValue());
		assertEquals(endLatitude, swapBox.getMaximumLatitudeValue());
	}

	/**
	 * Test method for {@link org.localbeat.api.geo.BoundingBox#getMaximumLongitudeValue()}.
	 */
	@Test
	void testGetMaximumLongitudeValue() {
		assertEquals(endLongitude, box.getMaximumLongitudeValue());
		assertEquals(endLongitude, swapBox.getMaximumLongitudeValue());
	}

	/**
	 * Test method for {@link org.localbeat.api.geo.BoundingBox#BoundingBox(Coordinate, Coordinate)}.
	 */
	@Test
	void testBoundingBoxCoordinateCoordinate() {
		assertEquals(new Coordinate(startLatitude, startLongitude), box.getMinPoint());
		assertEquals(new Coordinate(endLatitude, endLongitude), box.getMaxPoint());
	}

}
