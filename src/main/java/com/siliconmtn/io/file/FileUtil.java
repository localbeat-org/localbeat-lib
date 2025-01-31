package com.siliconmtn.io.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

/****************************************************************************
 * <b>Title:</b> FileUtil.java <br>
 * <b>Project:</b> localbeat-lib <br>
 * <b>Description:</b> Set of FileUtilities to handle simple file requests <br>
 * <b>Copyright:</b> Copyright (c) 2025 <br>
 * <b>Company:</b> Localbeat
 * 
 * @author etewa
 * @version 1.x
 * @since Jan 4, 2025
 * <b>updates:</b>
 * 
 ****************************************************************************/

public class FileUtil {

	/**
	 * Static class.  Need to create a private constructor
	 */
	private FileUtil() {
		super();
	}

	
	/**
	 * Loads a text file from the resources directory
	 * @throws IOException
	 */
	public static String loadTextResource(String path) throws IOException {
		ClassLoader classLoader = FileUtil.class.getClassLoader();
		URL fileUrl = classLoader.getResource(path);
		if (fileUrl == null) throw new IOException("Unable to locate file: " + path);
		
		File file = new File(fileUrl.getFile());
		StringBuilder sb = new StringBuilder();
		
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			int c;
			while((c=br.read()) > -1) sb.append((char)c);
		}
		
		return sb.toString();
	}
	
}
