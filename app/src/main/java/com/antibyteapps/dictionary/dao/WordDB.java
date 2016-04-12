package com.antibyteapps.dictionary.dao;

import com.antibyteapps.dictionary.common.DictionaryConstants;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author Orhun Dalabasmaz
 */
public class WordDB {
	private Set<String> words;

	public WordDB() {
		this.words = new LinkedHashSet<>();
	}

	public void addWord(String word) {
		words.add(word);
	}

	public boolean hasWord(String word) {
		if (word != null) {
			word = word.toLowerCase(DictionaryConstants.LOCALE_TR);
		}
		return words.contains(word);
	}
}
