package org.localbeat.api.gis.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title:</b> GeocodeParseExceptionTest.java <br>
 * <b>Project:</b> api <br>
 * <b>Description:</b> Test for the custom geocode exception <br>
 * <b>Copyright:</b> Copyright (c) 2024 <br>
 * <b>Company:</b> Localbeat
 * 
 * @author etewa
 * @version 1.x
 * @since Apr 3, 2024
 * <b>updates:</b>
 * 
 ****************************************************************************/
/**
 * 
 */
class GeocodeParseExceptionTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	protected void setUp() throws Exception {
	}

	/**
	 * Test method for {@link org.localbeat.api.gis.GeocodeParseException#GeocodeParseException()}.
	 */
	@Test
	void testGeocodeParseException() {
		GeocodeParseException gpe = new GeocodeParseException();
		assertNotNull(gpe);
	}

	/**
	 * Test method for {@link org.localbeat.api.gis.GeocodeParseException#GeocodeParseException(java.lang.String)}.
	 */
	@Test
	void testGeocodeParseExceptionString() {
		GeocodeParseException gpe = new GeocodeParseException("Testing");
		assertEquals("Testing", gpe.getMessage());
	}

	/**
	 * Test method for {@link org.localbeat.api.gis.GeocodeParseException#GeocodeParseException(java.lang.Throwable)}.
	 */
	@Test
	void testGeocodeParseExceptionThrowable() {
		Throwable t = new Throwable("Testing");
		GeocodeParseException gpe = new GeocodeParseException(t);
		assertEquals("java.lang.Throwable: Testing", gpe.getMessage());
	}

	/**
	 * Test method for {@link org.localbeat.api.gis.GeocodeParseException#GeocodeParseException(java.lang.String, java.lang.Throwable)}.
	 */
	@Test
	void testGeocodeParseExceptionStringThrowable() {
		Throwable t = new Throwable("Testing");
		GeocodeParseException gpe = new GeocodeParseException("HelloWorld", t);
		assertEquals("HelloWorld", gpe.getMessage());
	}

	/**
	 * Test method for {@link org.localbeat.api.gis.GeocodeParseException#GeocodeParseException(java.lang.String, java.lang.Throwable, boolean, boolean)}.
	 */
	@Test
	void testGeocodeParseExceptionStringThrowableBooleanBoolean() {
		Throwable t = new Throwable("Testing");
		GeocodeParseException gpe = new GeocodeParseException("HelloWorld", t, true, true);
		System.out.println(gpe.getMessage());
		assertEquals("HelloWorld", gpe.getMessage());
	}

}