package com.siliconmtn.data.format;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import com.siliconmtn.data.exception.InvalidDataException;
import com.siliconmtn.data.text.StringUtil;
import lombok.extern.log4j.Log4j2;

/****************************************************************************
 * <b>Title:</b> KeywordMatcher.java <br>
 * <b>Project:</b> Localbeat Lib <br>
 * <b>Description:</b> Takes a map of keywords (synonyms) and matches against
 * the provided string of data <br>
 * <b>Copyright:</b> Copyright (c) 2024 <br>
 * <b>Company:</b> Localbeat
 * 
 * @author etewa
 * @version 1.x
 * @since Dec 30, 2024
 * <b>updates:</b>
 * 
 ****************************************************************************/
@Log4j2
public class KeywordMatcher {
	
	private Map<String, String> keywords;
	private String sourceText;
	
	/**
	 * 
	 * @param sourceText
	 * @param keywords
	 * @throws InvalidDataException
	 */
	public KeywordMatcher(String sourceText, Map<String, String> keywords) throws InvalidDataException {
		if (keywords == null || keywords.isEmpty() || StringUtil.isEmpty(sourceText))
			throw new InvalidDataException("Keywords and source text must be present ");
		
		this.keywords = keywords;
		this.sourceText = sourceText;
	}

	
	/**
	 * Finds all of the matching keywords
	 * @return
	 */
	public Set<String> findKeywordMatches() {
		Set<String> matches = new HashSet<>();
		
        List<String> results = checkIfListWordMatches(sourceText.toLowerCase(), keywords.keySet());
        for(String cat : results) matches.add(keywords.get(cat));
        
        return matches;
	}

	/**
	 * Gets the list of matching categories
	 * @param inputText Source text to check against
	 * @param keywords Keywords to be found
	 * @return Colleciton of matching keywords
	 */
    protected List<String> checkIfListWordMatches(final String inputText, Set<String> keywords){
    	 
        return keywords.stream()
                .filter(s -> inputText.matches(".*\\b" + s.toLowerCase() + "\\b.*"))
                .toList();

    }
}
