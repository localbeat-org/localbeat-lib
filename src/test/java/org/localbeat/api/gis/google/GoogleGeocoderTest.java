package org.localbeat.api.gis.google;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.io.InputStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.localbeat.api.gis.data.AbstractGeocoder;
import org.localbeat.api.gis.data.GeolocationDTO;
import org.localbeat.api.gis.data.LocationDTO;
import org.localbeat.api.gis.util.GeocodeParseException;
import org.localbeat.api.gis.util.GeocoderConfigDTO;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;

/****************************************************************************
 * <b>Title:</b> GoogleGeocoderTest.java <br>
 * <b>Project:</b> localbeat-lib <br>
 * <b>Description:</b> --- Change Me -- <br>
 * <b>Copyright:</b> Copyright (c) 2024 <br>
 * <b>Company:</b> Localbeat
 * 
 * @author etewa
 * @version 1.x
 * @since Sep 30, 2024
 * <b>updates:</b>
 * 
 ****************************************************************************/
@ExtendWith(MockitoExtension.class)
class GoogleGeocoderTest {
	@Mock
	private GeocoderConfigDTO config;

	@Mock
	private RestTemplate rt;
	
	@InjectMocks
	private GoogleGeocoder gg;
	
	// Members
	StringBuilder zipJson;
	String resourceName = "json/google_zip.json";

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	protected void setUp() throws Exception {
		config = new GeocoderConfigDTO();
		config.setClazz("org.localbeat.api.gis.google.GoogleGeocoder");
		config.setKey("123");
		config.setUrl("https://maps.googleapis.com/maps/api/geocode/json?key=$KEY&address=$ADDRESS");
		gg = new GoogleGeocoder(config);
		gg.rt = rt;
		
		// Load a sample google json file
		zipJson = new StringBuilder();
		try (InputStream is = getClass().getClassLoader().getResourceAsStream(resourceName)) {
			int c = 0;
			while ((c=is.read()) > -1) {
				zipJson.append((char)c);
			}
		}
	}

	/**
	 * Test method for {@link org.localbeat.api.gis.google.GoogleGeocoder#geocode(org.localbeat.api.gis.data.LocationDTO)}.
	 */
	@Test
	void testGeocode() {
		LocationDTO loc = new LocationDTO();
		loc.setZip("80007");
		when(rt.getForObject("https://maps.googleapis.com/maps/api/geocode/json?key=123&address=80007", String.class)).thenReturn(zipJson.toString());
		String res = gg.getGeocode(loc);
		assertEquals(zipJson.toString(), res);
	}

	/**
	 * Test method for {@link org.localbeat.api.gis.google.GoogleGeocoder#toString()}.
	 */
	@Test
	void testToString() {
		config.setClazz("org.localbeat.api.gis.google.GoogleGeocoder");
		config.setKey("123");
		config.setUrl("https://www.somedomain.com");
		
		AbstractGeocoder ag = new GoogleGeocoder(config);
		String r = "Geocoder Instance: GeocoderConfigDTO(key=123, url=https://www.somedomain.com, clazz=org.localbeat.api.gis.google.GoogleGeocoder)";
		
		assertEquals(r, ag.toString());
	}

	/**
	 * Test method for {@link org.localbeat.api.gis.google.GoogleGeocoder#getGeocode(org.localbeat.api.gis.data.LocationDTO)}.
	 */
	@Test
	void testGetGeocode() throws GeocodeParseException {
		LocationDTO loc = new LocationDTO();
		loc.setZip("80007");
		when(rt.getForObject("https://maps.googleapis.com/maps/api/geocode/json?key=123&address=80007", String.class)).thenReturn(zipJson.toString());
		GeolocationDTO res = gg.geocode(loc);
		assertEquals("80007", res.getZip());
	}

	/**
	 * Test method for {@link org.localbeat.api.gis.google.GoogleGeocoder#geocode(org.localbeat.api.gis.data.LocationDTO)}.
	 * @throws IOException 
	 * @throws GeocodeParseException 
	 */
	@Test
	void testGeocodeWithException() throws GeocodeParseException {
		LocationDTO loc = new LocationDTO();
		loc.setZip("80007");
		when(rt.getForObject("https://maps.googleapis.com/maps/api/geocode/json?key=123&address=80007", String.class)).thenThrow(RuntimeException.class);
		Exception e = assertThrows(GeocodeParseException.class, () -> {
			gg.geocode(loc);
		});
		
		assertTrue(e.getMessage().contains("Unable to geocode address:"));
	}

	/**
	 * Test method for {@link org.localbeat.api.gis.google.GoogleGeocoder#geocode(org.localbeat.api.gis.data.LocationDTO)}.
	 * @throws IOException 
	 * @throws GeocodeParseException 
	 */
	@Test
	void testGeocodeNoKey() {
		LocationDTO loc = new LocationDTO();
		loc.setZip("80007");
		config.setKey(null);
		assertThrows(GeocodeParseException.class, () -> {
			gg.geocode(loc);
		});
	}
	
	/**
	 * Test method for {@link org.localbeat.api.gis.google.GoogleGeocoder#geocode(org.localbeat.api.gis.data.LocationDTO)}.
	 * @throws IOException 
	 * @throws GeocodeParseException 
	 */
	@Test
	void testGeocodeNoUrl() {
		LocationDTO loc = new LocationDTO();
		loc.setZip("80007");
		config.setUrl(null);
		assertThrows(GeocodeParseException.class, () -> {
			gg.geocode(loc);
		});
	}
}
