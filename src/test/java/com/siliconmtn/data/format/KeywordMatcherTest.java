package com.siliconmtn.data.format;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.siliconmtn.data.exception.InvalidDataException;

/****************************************************************************
 * <b>Title:</b> KeywordMatcherTest.java <br>
 * <b>Project:</b> localbeat-lib <br>
 * <b>Description:</b> unit tests for the keyword matcher <br>
 * <b>Copyright:</b> Copyright (c) 2024 <br>
 * <b>Company:</b> Localbeat
 * 
 * @author etewa
 * @version 1.x
 * @since Dec 30, 2024
 * <b>updates:</b>
 * 
 ****************************************************************************/

class KeywordMatcherTest {
	
	// Members
	private Map<String, String> categories;
	String source;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	protected void setUp() throws Exception {
		source="We love to play hockey listening to rock & roll";
		
        categories = new HashMap<>();
        categories.put("rock", "ROCK");
        categories.put("rock and roll", "ROCK");
        categories.put("rock & roll", "ROCK");
        categories.put("ice hockey", "ICE_HOCKEY");
        categories.put("hockey", "ICE_HOCKEY");
        categories.put("nhl", "ICE_HOCKEY");
	}

	/**
	 * Test method for {@link com.siliconmtn.data.format.KeywordMatcher#KeywordMatcher(java.lang.String, java.util.Map)}.
	 * @throws InvalidDataException 
	 */
	@Test
	void testKeywordMatcher() {
		KeywordMatcher km = new KeywordMatcher(categories);
		assertNotNull(km);
	}

	/**
	 * Test method for {@link com.siliconmtn.data.format.KeywordMatcher#findKeywordMatchesReturnCode(java.lang.String)}.
	 * @throws InvalidDataException 
	 */
	@Test
	void testFindKeywordMatchesReturnCode() throws InvalidDataException {
		KeywordMatcher km = new KeywordMatcher(categories);
		Set<String> matches = km.findKeywordMatchesReturnCode(source);
		System.out.println(matches);
		
		assertEquals(2, matches.size());
		assertTrue(matches.contains("ROCK"));
		assertTrue(matches.contains("ICE_HOCKEY"));
	}

	/**
	 * Test method for {@link com.siliconmtn.data.format.KeywordMatcher#findKeywordMatchesReturnCode(java.lang.String)}.
	 * @throws InvalidDataException 
	 */
	@Test
	void testFindKeywordMatchesReturnCodeNoCat() throws InvalidDataException {
		KeywordMatcher km = new KeywordMatcher(new HashMap<>());
		
		assertThrows(InvalidDataException.class, () -> {
			km.findKeywordMatchesReturnCode(source);
		});
	}

	/**
	 * Test method for {@link com.siliconmtn.data.format.KeywordMatcher#findKeywordMatchesReturnCode(java.lang.String)}.
	 * @throws InvalidDataException 
	 */
	@Test
	void testFindKeywordMatchesReturnCodeNullCat() throws InvalidDataException {
		KeywordMatcher km = new KeywordMatcher(null);
		
		assertThrows(InvalidDataException.class, () -> {
			km.findKeywordMatchesReturnCode(source);
		});
	}
	
	/**
	 * Test method for {@link com.siliconmtn.data.format.KeywordMatcher#findKeywordMatchesReturnCode(java.lang.String)}.
	 * @throws InvalidDataException 
	 */
	@Test
	void testFindKeywordMatchesReturnCodeNoSource() throws InvalidDataException {
		KeywordMatcher km = new KeywordMatcher(categories);
		
		assertThrows(InvalidDataException.class, () -> {
			km.findKeywordMatchesReturnCode(null);
		});
	}
	
	/**
	 * Test method for {@link com.siliconmtn.data.format.KeywordMatcher#findKeywordMatchesReturnAlias(java.lang.String)}.
	 * @throws InvalidDataException 
	 */
	@Test
	void testFindKeywordMatchesReturnAlias() throws InvalidDataException {
		KeywordMatcher km = new KeywordMatcher(categories);
		Set<String> matches = km.findKeywordMatchesReturnAlias(source);
		System.out.println(matches);
		
		assertEquals(3, matches.size());
		assertTrue(matches.contains("rock"));
		assertTrue(matches.contains("hockey"));
		assertTrue(matches.contains("rock & roll"));
	}
	
	/**
	 * Test method for {@link com.siliconmtn.data.format.KeywordMatcher#findKeywordMatchesReturnAlias(java.lang.String)}.
	 * @throws InvalidDataException 
	 */
	@Test
	void testFindKeywordMatchesReturnAliasNoCat() throws InvalidDataException {
		KeywordMatcher km = new KeywordMatcher(new HashMap<>());
		
		assertThrows(InvalidDataException.class, () -> {
			km.findKeywordMatchesReturnAlias(source);
		});
	}

	/**
	 * Test method for {@link com.siliconmtn.data.format.KeywordMatcher#findKeywordMatchesReturnAlias(java.lang.String)}.
	 * @throws InvalidDataException 
	 */
	@Test
	void testFindKeywordMatchesReturnAliasNullCat() throws InvalidDataException {
		KeywordMatcher km = new KeywordMatcher(null);
		
		assertThrows(InvalidDataException.class, () -> {
			km.findKeywordMatchesReturnAlias(source);
		});
	}
	
	/**
	 * Test method for {@link com.siliconmtn.data.format.KeywordMatcher#findKeywordMatchesReturnAlias(java.lang.String)}.
	 * @throws InvalidDataException 
	 */
	@Test
	void testFindKeywordMatchesReturnAliasNoSource() throws InvalidDataException {
		KeywordMatcher km = new KeywordMatcher(categories);
		
		assertThrows(InvalidDataException.class, () -> {
			km.findKeywordMatchesReturnAlias(null);
		});
	}
}
