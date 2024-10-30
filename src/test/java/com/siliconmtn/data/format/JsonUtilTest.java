package com.siliconmtn.data.format;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title:</b> JsonUtilTest.java <br>
 * <b>Project:</b> localbeat-lib <br>
 * <b>Description:</b> unit tests for the JsonUtil class <br>
 * <b>Copyright:</b> Copyright (c) 2024 <br>
 * <b>Company:</b> Localbeat
 * 
 * @author etewa
 * @version 1.x
 * @since Oct 30, 2024
 * <b>updates:</b>
 * 
 ****************************************************************************/

class JsonUtilTest {

	/**
	 * Test method for {@link com.siliconmtn.data.format.JsonUtil#isJsonValid(java.lang.String)}.
	 */
	@Test
	void testIsJsonValid() {
		String json = "{ \"num-days\" : 3}";
		assertTrue(JsonUtil.isJsonValid(json));
	}

	/**
	 * Test method for {@link com.siliconmtn.data.format.JsonUtil#isJsonValid(java.lang.String)}.
	 */
	@Test
	void testIsJsonValidError() {
		String json = "{ \"num-days : 3}";
		assertFalse(JsonUtil.isJsonValid(json));
	}
}
