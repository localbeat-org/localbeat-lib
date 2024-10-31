/****************************************************************************
 * <b>Title:</b> GeocoderFactoryTest.java <br>
 * <b>Project:</b> api <br>
 * <b>Description:</b> --- Change Me -- <br>
 * <b>Copyright:</b> Copyright (c) 2024 <br>
 * <b>Company:</b> Localbeat
 * 
 * @author etewa
 * @version 1.x
 * @since Apr 3, 2024
 * <b>updates:</b>
 * 
 ****************************************************************************/
package org.localbeat.api.gis.util;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.localbeat.api.gis.data.AbstractGeocoder;

/****************************************************************************
 * <b>Title:</b> GeocoderFactoryTest.java <br>
 * <b>Project:</b> localbeat-lib <br>
 * <b>Description:</b> Unit tests for the Geocoder Factory <br>
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
class GeocoderFactoryTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	protected void setUp() throws Exception {
	}

	/**
	 * Test method for {@link org.localbeat.api.gis.GeocoderFactory#getInstance(org.localbeat.api.util.GeocoderConfigDTO)}.
	 * @throws ClassNotFoundException 
	 */
	@Test
	void testGetInstance() throws ClassNotFoundException {
		GeocoderConfigDTO config = new GeocoderConfigDTO();
		config.setClazz("org.localbeat.api.gis.google.GoogleGeocoder");
		AbstractGeocoder ag = GeocoderFactory.getInstance(config);
		assertNotNull(ag);
	}

	/**
	 * Test method for {@link org.localbeat.api.gis.GeocoderFactory#getInstance(org.localbeat.api.util.GeocoderConfigDTO)}.
	 * @throws ClassNotFoundException 
	 */
	@Test
	void testGetInstanceExcpetion() throws ClassNotFoundException {
		GeocoderConfigDTO config = new GeocoderConfigDTO();
		config.setClazz("org.localbeat.api.gis.google.MissingClas");
		Exception exception = assertThrows(Exception.class, () -> {
			GeocoderFactory.getInstance(config);
	    });
		
		assertTrue(exception.getMessage().contains("instantiate"));
	}
}

