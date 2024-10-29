package com.siliconmtn.data.format;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/****************************************************************************
 * <b>Title:</b> JsonUtil.java <br>
 * <b>Project:</b> email_campaign <br>
 * <b>Description:</b> Utility class for managing json objects <br>
 * <b>Copyright:</b> Copyright (c) 2024 <br>
 * <b>Company:</b> Localbeat
 * 
 * @author etewa
 * @version 1.x
 * @since Jul 30, 2024
 * <b>updates:</b>
 * 
 ****************************************************************************/

public class JsonUtil {
	
	/**
	 * Only static methods right now
	 */
	private JsonUtil() {
		super();
	}
	
	/**
	 * Tests a String to make sure it is json data
	 * @param inputJosn
	 * @return True if json.  False otherwise
	 */
	public static boolean isJsonValid(String inputJosn) {
		ObjectMapper mapper = new ObjectMapper()
				  .enable(DeserializationFeature.FAIL_ON_TRAILING_TOKENS);
		
		try {
            JsonFactory factory = mapper.getFactory();
            JsonParser parser = factory.createParser(inputJosn);
            mapper.readTree(parser);
           
		} catch (Exception e) {
			return false;
		}
		
		return true;
	}

}
