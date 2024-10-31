package org.localbeat.api.gis.google;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.localbeat.api.geo.Coordinate;
import org.localbeat.api.gis.data.GeolocationDTO;
import org.localbeat.api.gis.data.GeolocationDTO.MatchCode;
import org.localbeat.api.gis.google.GoogleGeocodeDTO.LocationType;
import org.localbeat.api.gis.google.GoogleGeocodeDTO.StatusCode;

/****************************************************************************
 * <b>Title:</b> GoogleGeocodeDTOTest.java <br>
 * <b>Project:</b> localbeat-lib <br>
 * <b>Description:</b> Google Geocode DTO unit tests <br>
 * <b>Copyright:</b> Copyright (c) 2024 <br>
 * <b>Company:</b> Localbeat
 * 
 * @author etewa
 * @version 1.x
 * @since Sep 30, 2024
 * <b>updates:</b>
 * 
 ****************************************************************************/

class GoogleGeocodeDTOTest {
	
	GoogleGeocodeDTO geoDto;
	List<Address> results;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	protected void setUp() throws Exception {
		geoDto = new GoogleGeocodeDTO();
		
		results = new ArrayList<Address>();
		Address a = new Address();
		a.setFormattedAddress("15602 West 79th Pl, Arvada, CO 80007, US");
		a.setPlaceId("12345");
		
		List<AddressType> addressComponents = new ArrayList<>();
		AddressType at1 = new AddressType();
		at1.setLongName("Colorado");
		at1.setShortName("CO");
		List<TypePart> types = new ArrayList<>();
		types.add(TypePart.ADMINISTRATIVE_AREA_LEVEL_1);
		at1.setTypes(types);
		
		AddressType at2 = new AddressType();
		at2.setLongName("Main ST");
		at2.setShortName("Main St");
		List<TypePart> types1 = new ArrayList<>();
		types1.add(TypePart.ROUTE);
		at2.setTypes(types1);
		
		addressComponents.add(at1);
		addressComponents.add(at2);
		
		Geometry geometry = new Geometry();
		Coordinate c = new Coordinate(100,100);
		geometry.setLocation(c);
		a.setGeometry(geometry);
		a.setAddressComponents(addressComponents);
		results.add(a);
		
		geoDto.setResults(results);
	}

	/**
	 * Test method for {@link org.localbeat.api.gis.google.GoogleGeocodeDTO#assignMatchCode(org.localbeat.api.gis.data.GeolocationDTO)}.
	 */
	@Test
	void testAssignMatchCodeNoData() {
		GeolocationDTO dto = new GeolocationDTO();
		geoDto.assignMatchCode(dto);
		assertEquals(MatchCode.NO_MATCH, geoDto.getMatchCode());
		
	}
	
	/**
	 * Test method for {@link org.localbeat.api.gis.google.GoogleGeocodeDTO#assignMatchCode(org.localbeat.api.gis.data.GeolocationDTO)}.
	 */
	@Test
	void testAssignMatchCodeNoDataWithLat() {
		GeolocationDTO dto = new GeolocationDTO();
		dto.setLatitude(100);
		geoDto.assignMatchCode(dto);
		assertEquals(MatchCode.NO_MATCH, geoDto.getMatchCode());
		
	}
	
	/**
	 * Test method for {@link org.localbeat.api.gis.google.GoogleGeocodeDTO#assignMatchCode(org.localbeat.api.gis.data.GeolocationDTO)}.
	 */
	@Test
	void testAssignMatchCodeNoDataWithLng() {
		GeolocationDTO dto = new GeolocationDTO();
		dto.setLongitude(100);
		geoDto.assignMatchCode(dto);
		assertEquals(MatchCode.NO_MATCH, geoDto.getMatchCode());
		
	}
	
	/**
	 * Test method for {@link org.localbeat.api.gis.google.GoogleGeocodeDTO#assignMatchCode(org.localbeat.api.gis.data.GeolocationDTO)}.
	 */
	@Test
	void testAssignMatchCodeWithAddress() {
		GeolocationDTO dto = new GeolocationDTO();
		dto.setLatitude(100);
		dto.setLongitude(100);
		dto.setAddress("100 Main Street");
		geoDto.assignMatchCode(dto);
		assertEquals(MatchCode.ADDRESS, geoDto.getMatchCode());
	}
	
	/**
	 * Test method for {@link org.localbeat.api.gis.google.GoogleGeocodeDTO#assignMatchCode(org.localbeat.api.gis.data.GeolocationDTO)}.
	 */
	@Test
	void testAssignMatchCodeWithZip() {
		GeolocationDTO dto = new GeolocationDTO();
		dto.setLatitude(100);
		dto.setLongitude(100);
		dto.setZip("80007");
		geoDto.assignMatchCode(dto);
		assertEquals(MatchCode.ZIP, geoDto.getMatchCode());
	}
	
	/**
	 * Test method for {@link org.localbeat.api.gis.google.GoogleGeocodeDTO#assignMatchCode(org.localbeat.api.gis.data.GeolocationDTO)}.
	 */
	@Test
	void testAssignMatchCodeWithCity() {
		GeolocationDTO dto = new GeolocationDTO();
		dto.setLatitude(100);
		dto.setLongitude(100);
		dto.setCity("Arvada");
		geoDto.assignMatchCode(dto);
		assertEquals(MatchCode.CITY, geoDto.getMatchCode());
		
		geoDto.setMatchCode(null);
		dto = new GeolocationDTO();
		dto.setLatitude(100);
		dto.setLongitude(100);
		dto.setCounty("Jefferson");
		geoDto.assignMatchCode(dto);
		assertEquals(MatchCode.COUNTY, geoDto.getMatchCode());
	}
	
	/**
	 * Test method for {@link org.localbeat.api.gis.google.GoogleGeocodeDTO#assignMatchCode(org.localbeat.api.gis.data.GeolocationDTO)}.
	 */
	@Test
	void testAssignMatchCodeWithStateCountry() {
		GeolocationDTO dto = new GeolocationDTO();
		dto.setLatitude(100);
		dto.setLongitude(100);
		dto.setState("CO");
		geoDto.assignMatchCode(dto);
		assertEquals(MatchCode.STATE, geoDto.getMatchCode());
		
		geoDto.setMatchCode(null);
		dto = new GeolocationDTO();
		dto.setLatitude(100);
		dto.setLongitude(100);
		dto.setCountry("US");
		geoDto.assignMatchCode(dto);
		assertEquals(MatchCode.COUNTRY, geoDto.getMatchCode());
	}
	
	/**
	 * Test method for {@link org.localbeat.api.gis.google.GoogleGeocodeDTO#assignMatchCode(org.localbeat.api.gis.data.GeolocationDTO)}.
	 */
	@Test
	void testAssignMatchCodeWithNoMatch() {
		geoDto.setMatchCode(MatchCode.ADDRESS);
		final GeolocationDTO fdto = new GeolocationDTO();
		assertDoesNotThrow(() -> geoDto.assignMatchCode(fdto));
		
		geoDto.setMatchCode(null);
		GeolocationDTO dto = new GeolocationDTO();
		dto.setLatitude(100);
		dto.setLongitude(100);
		geoDto.assignMatchCode(dto);
		assertEquals(MatchCode.NO_MATCH, geoDto.getMatchCode());
	}
	

	/**
	 * Test method for {@link org.localbeat.api.gis.google.GoogleGeocodeDTO#assignMatchCode(org.localbeat.api.gis.data.GeolocationDTO)}.
	 */
	@Test
	void testEnums() {
		assertTrue("APPROXIMATE".equalsIgnoreCase(LocationType.APPROXIMATE.toString()));
		assertTrue("GEOMETRIC_CENTER".equalsIgnoreCase(LocationType.GEOMETRIC_CENTER.toString()));
		assertTrue("RANGE_INTERPOLATED".equalsIgnoreCase(LocationType.RANGE_INTERPOLATED.toString()));
		assertTrue("ROOFTOP".equalsIgnoreCase(LocationType.ROOFTOP.toString()));
		assertTrue("OK".equalsIgnoreCase(StatusCode.OK.toString()));
		assertTrue("OVER_DAILY_LIMIT".equalsIgnoreCase(StatusCode.OVER_DAILY_LIMIT.toString()));
		assertTrue("ZERO_RESULTS".equalsIgnoreCase(StatusCode.ZERO_RESULTS.toString()));
		assertTrue("OVER_QUERY_LIMIT".equalsIgnoreCase(StatusCode.OVER_QUERY_LIMIT.toString()));
		assertTrue("REQUEST_DENIED".equalsIgnoreCase(StatusCode.REQUEST_DENIED.toString()));
		assertTrue("INVALID_REQUEST".equalsIgnoreCase(StatusCode.INVALID_REQUEST.toString()));
		assertTrue("UNKNOWN_ERROR".equalsIgnoreCase(StatusCode.UNKNOWN_ERROR.toString()));
		assertTrue("street_address".equalsIgnoreCase(TypePart.STREET_ADDRESS.toString()));
		assertTrue("route".equalsIgnoreCase(TypePart.ROUTE.toString()));
		assertTrue("intersection".equalsIgnoreCase(TypePart.INTERSECTION.toString()));
		assertTrue("political".equalsIgnoreCase(TypePart.POLITICAL.toString()));
		assertTrue("country".equalsIgnoreCase(TypePart.COUNTRY.toString()));
	}	
		
	/**
	 * Test method for {@link org.localbeat.api.gis.google.GoogleGeocodeDTO#assignMatchCode(org.localbeat.api.gis.data.GeolocationDTO)}.
	 */
	@Test
	void testEnumsMore() {	
		assertTrue("administrative_area_level_1".equalsIgnoreCase(TypePart.ADMINISTRATIVE_AREA_LEVEL_1.toString()));
		assertTrue("administrative_area_level_2".equalsIgnoreCase(TypePart.ADMINISTRATIVE_AREA_LEVEL_2.toString()));
		assertTrue("administrative_area_level_3".equalsIgnoreCase(TypePart.ADMINISTRATIVE_AREA_LEVEL_3.toString()));
		assertTrue("administrative_area_level_4".equalsIgnoreCase(TypePart.ADMINISTRATIVE_AREA_LEVEL_4.toString()));
		assertTrue("administrative_area_level_5".equalsIgnoreCase(TypePart.ADMINISTRATIVE_AREA_LEVEL_5.toString()));
		assertTrue("administrative_area_level_6".equalsIgnoreCase(TypePart.ADMINISTRATIVE_AREA_LEVEL_6.toString()));
		assertTrue("administrative_area_level_7".equalsIgnoreCase(TypePart.ADMINISTRATIVE_AREA_LEVEL_7.toString()));
		assertTrue("colloquial_area".equalsIgnoreCase(TypePart.COLLOQUIAL_AREA.toString()));
		assertTrue("locality".equalsIgnoreCase(TypePart.LOCALITY.toString()));
		assertTrue("sublocality".equalsIgnoreCase(TypePart.SUBLOCALITY.toString()));
		assertTrue("sublocality_level_5".equalsIgnoreCase(TypePart.SUBLOCALITY_LEVEL_5.toString()));
		assertTrue("neighborhood".equalsIgnoreCase(TypePart.NEIGHBORHOOD.toString()));
		assertTrue("premise".equalsIgnoreCase(TypePart.PREMISE.toString()));
		assertTrue("subpremise".equalsIgnoreCase(TypePart.SUBPREMISE.toString()));
		assertTrue("plus_code".equalsIgnoreCase(TypePart.PLUS_CODE.toString()));
		assertTrue("postal_code".equalsIgnoreCase(TypePart.POSTAL_CODE.toString()));
		assertTrue("natural_feature".equalsIgnoreCase(TypePart.NATURAL_FEATURE.toString()));
		assertTrue("airport".equalsIgnoreCase(TypePart.AIRPORT.toString()));
		assertTrue("park".equalsIgnoreCase(TypePart.PARK.toString()));
		assertTrue("point_of_interest".equalsIgnoreCase(TypePart.POINT_OF_INTEREST.toString()));
		assertTrue("street_number".equalsIgnoreCase(TypePart.STREET_NUMBER.toString()));
		assertTrue("postal_code_suffix".equalsIgnoreCase(TypePart.POSTAL_CODE_SUFFIX.toString()));
	}
	
	/**
	 * Test method for {@link org.localbeat.api.gis.google.GoogleGeocodeDTO#getValue(org.localbeat.api.gis.google.GoogleGeocodeDTO.TypePart)}.
	 */
	@Test
	void testGetValue() {

		String val = geoDto.getValue(TypePart.ADMINISTRATIVE_AREA_LEVEL_1);
		assertEquals("CO", val);
	}
	
	/**
	 * Test method for {@link org.localbeat.api.gis.google.GoogleGeocodeDTO#getValue(org.localbeat.api.gis.google.GoogleGeocodeDTO.TypePart)}.
	 */
	@Test
	void testGetValueNoResponse() {

		String val = geoDto.getValue(TypePart.ADMINISTRATIVE_AREA_LEVEL_2);
		assertEquals("", val);
	}
	
	/**
	 * Test method for {@link org.localbeat.api.gis.google.GoogleGeocodeDTO#getValue(org.localbeat.api.gis.google.GoogleGeocodeDTO.TypePart)}.
	 */
	@Test
	void testGetValueNullResults() {
		geoDto.setResults(null);
		String val = geoDto.getValue(TypePart.ADMINISTRATIVE_AREA_LEVEL_2);
		assertNull(val);
	}
	
	/**
	 * Test method for {@link org.localbeat.api.gis.google.GoogleGeocodeDTO#getValue(org.localbeat.api.gis.google.GoogleGeocodeDTO.TypePart)}.
	 */
	@Test
	void testGetValueEmptyResults() {
		geoDto.setResults(new ArrayList<>());
		String val = geoDto.getValue(TypePart.ADMINISTRATIVE_AREA_LEVEL_2);
		assertNull(val);
	}
	
	/**
	 * Test method for {@link org.localbeat.api.gis.google.GoogleGeocodeDTO#getValue(org.localbeat.api.gis.google.GoogleGeocodeDTO.TypePart)}.
	 */
	@Test
	void testGetValueIntersection() {
		List<TypePart> types = new ArrayList<>();
		types.add(TypePart.INTERSECTION);
		results.get(0).getAddressComponents().get(0).setTypes(types);
		geoDto.getValue(TypePart.INTERSECTION);
		assertEquals(MatchCode.INTERSECTION, geoDto.getMatchCode());
	}


	/**
	 * Test method for {@link org.localbeat.api.gis.google.GoogleGeocodeDTO#getGeolocation()}.
	 */
	@Test
	void testGetGeolocation() {
		GeolocationDTO dto = geoDto.getGeolocation();
		assertEquals(MatchCode.STREET, dto.getMatchCode());
	}
	
	/**
	 * Test method for {@link org.localbeat.api.gis.google.GoogleGeocodeDTO#getGeolocation()}.
	 */
	@Test
	void testGetGeolocationNullResults() {
		geoDto.setResults(null);
		GeolocationDTO dto = geoDto.getGeolocation();
		assertEquals(MatchCode.NO_MATCH, dto.getMatchCode());
	}
	
	/**
	 * Test method for {@link org.localbeat.api.gis.google.GoogleGeocodeDTO#getGeolocation()}.
	 */
	@Test
	void testGetGeolocationEmptyResults() {
		geoDto.setResults(new ArrayList<>());
		GeolocationDTO dto = geoDto.getGeolocation();
		assertEquals(MatchCode.NO_MATCH, dto.getMatchCode());
	}
	
	/**
	 * Test method for {@link org.localbeat.api.gis.google.GoogleGeocodeDTO#getGeolocation()}.
	 */
	@Test
	void testGetGeolocationWithStreet() {
		AddressType at2 = new AddressType();
		at2.setLongName("100");
		at2.setShortName("100");
		List<TypePart> types1 = new ArrayList<>();
		types1.add(TypePart.STREET_NUMBER);
		at2.setTypes(types1);
		results.get(0).getAddressComponents().add(at2);
		
		GeolocationDTO dto = geoDto.getGeolocation();
		assertEquals(MatchCode.ADDRESS, dto.getMatchCode());
	}
	
	/**
	 * Test method for {@link org.localbeat.api.gis.google.GoogleGeocodeDTO#getGeolocation()}.
	 */
	@Test
	void testGetGeolocationNoRoute() {
		results.get(0).getAddressComponents().remove(1);
		System.out.println(results.get(0).getAddressComponents());
		GeolocationDTO dto = geoDto.getGeolocation();
		assertEquals(MatchCode.STATE, dto.getMatchCode());
	}
}