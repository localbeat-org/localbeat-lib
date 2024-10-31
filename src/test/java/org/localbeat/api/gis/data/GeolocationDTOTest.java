package org.localbeat.api.gis.data;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.localbeat.api.gis.data.GeolocationDTO.MatchCode;

/****************************************************************************
 * <b>Title:</b> GeolocationDTOTest.java <br>
 * <b>Project:</b> localbeat-api <br>
 * <b>Description:</b> Unit tests the geolocation DTO class <br>
 * <b>Copyright:</b> Copyright (c) 2023 <br>
 * <b>Company:</b> Local Beats
 * 
 * @author etewa
 * @version 1.x
 * @since Apr 6, 2024
 * <b>updates:</b>
 * 
 ****************************************************************************/
class GeolocationDTOTest {

	/**
	 * Test method for {@link org.localbeat.api.gis.data.GeolocationDTO#getFormattedAddress()}.
	 */
	@Test
	void testGetFormattedAddress() {
		GeolocationDTO dto = new GeolocationDTO();
		dto.setAddress("15602 West 79th Place");
		dto.setCity("Arvada");
		dto.setState("CO");
		dto.setZip("80007");
		
		assertEquals("15602 West 79th Place, Arvada, CO, 80007, NO_MATCH", dto.getFormattedAddress());
		assertEquals("No Match" ,dto.getMatchCode().getName() );
	}

	/**
	 * Test method for {@link org.localbeat.api.gis.data.GeolocationDTO#getFormattedAddress()}.
	 */
	@Test
	void testGetMatchCode() {
		GeolocationDTO dto = new GeolocationDTO();
		dto.setMatchCode(MatchCode.MANUAL);
		
		assertEquals("Manually Assigned Geocode", dto.getMatchCode().getName());
	}
}
