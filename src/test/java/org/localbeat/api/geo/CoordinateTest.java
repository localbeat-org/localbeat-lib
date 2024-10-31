package org.localbeat.api.geo;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title:</b> CoordinateTest.java <br>
 * <b>Project:</b> Entertainment <br>
 * <b>Description:</b> Unit tests the coordinate class <br>
 * <b>Copyright:</b> Copyright (c) 2023 <br>
 * <b>Company:</b> Local Beats
 * 
 * @author etewa
 * @version 1.x
 * @since Mar 31, 2024
 * <b>updates:</b>
 * 
 ****************************************************************************/
class CoordinateTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	protected void setUp() throws Exception {
	}

	/**
	 * Test method for {@link org.localbeat.api.geo.Coordinate#hasCoodinate()}.
	 */
	@Test
	void testHasCoodinate() {
		double latitude = 39.8232;
		double longitude = -105.2825;
		Coordinate c = new Coordinate(latitude, longitude);
		
		assertTrue(c.hasCoodinate());
	}
	
	/**
	 * Test method for {@link org.localbeat.api.geo.Coordinate#hasCoodinate()}.
	 */
	@Test
	void testHasCoodinateNegLat() {
		double latitude = -39.8232;
		double longitude = -105.2825;
		Coordinate c = new Coordinate(latitude, longitude);
		
		assertTrue(c.hasCoodinate());
	}
	
	/**
	 * Test method for {@link org.localbeat.api.geo.Coordinate#hasCoodinate()}.
	 */
	@Test
	void testHasCoodinateNoLat() {
		double latitude = 0;
		double longitude = -105.2825;
		Coordinate c = new Coordinate(latitude, longitude);
		
		assertFalse(c.hasCoodinate());
	}

}
