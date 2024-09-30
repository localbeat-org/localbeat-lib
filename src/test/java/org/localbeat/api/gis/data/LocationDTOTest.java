/****************************************************************************
 * <b>Title:</b> LocationDTOTest.java <br>
 * <b>Project:</b> api <br>
 * <b>Description:</b> --- Change Me -- <br>
 * <b>Copyright:</b> Copyright (c) 2024 <br>
 * <b>Company:</b> Localbeat
 * 
 * @author etewa
 * @version 1.x
 * @since Apr 10, 2024
 * <b>updates:</b>
 * 
 ****************************************************************************/
package org.localbeat.api.gis.data;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title:</b> LocationDTOTest.java <br>
 * <b>Project:</b> api <br>
 * <b>Description:</b> Unit tests for the location dto object<br>
 * <b>Copyright:</b> Copyright (c) 2024 <br>
 * <b>Company:</b> Localbeat
 * 
 * @author etewa
 * @version 1.x
 * @since Apr 10, 2024
 * <b>updates:</b>
 * 
 ****************************************************************************/
/**
 * 
 */
class LocationDTOTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	protected void setUp() throws Exception {
	}

	/**
	 * Test method for {@link org.localbeat.api.gis.data.LocationDTO#getFormattedAddress()}.
	 */
	@Test
	void testGetFormattedAddress() {
		LocationDTO dto = new LocationDTO();
		dto.setAddress("15602 West 79th Place");
		dto.setCity("Arvada");
		dto.setState("CO");
		dto.setZip("80007");
		
		assertEquals("15602 West 79th Place, Arvada, CO, 80007", dto.getFormattedAddress());
	}

}

