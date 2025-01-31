package com.siliconmtn.io.file;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title:</b> FileUtilTest.java <br>
 * <b>Project:</b> localbeat-lib <br>
 * <b>Description:</b> --- Change Me -- <br>
 * <b>Copyright:</b> Copyright (c) 2025 <br>
 * <b>Company:</b> Localbeat
 * 
 * @author etewa
 * @version 1.x
 * @since Jan 7, 2025
 * <b>updates:</b>
 * 
 ****************************************************************************/

class FileUtilTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	protected void setUp() throws Exception {
	}

	/**
	 * Test method for {@link com.siliconmtn.io.file.FileUtil#loadTextResource(java.lang.String)}.
	 * @throws IOException 
	 */
	@Test
	void testLoadTextResourceError() throws IOException {
		assertThrows(IOException.class, () -> {
			FileUtil.loadTextResource("file/response.txt");
		});
		
	}

	/**
	 * Test method for {@link com.siliconmtn.io.file.FileUtil#loadTextResource(java.lang.String)}.
	 * @throws IOException 
	 */
	@Test
	void testLoadTextResource() throws IOException {
		String data = FileUtil.loadTextResource("files/response.txt");
		assertEquals("Hello World", data);
	}
}
