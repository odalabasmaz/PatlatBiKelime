package com.antibyteapps.dictionary.service;

import com.antibyteapps.dictionary.dao.WordDB;

/**
 * @author Orhun Dalabasmaz
 */
public class DictionaryService {
	private static DictionaryService service;
	private static WordDB DICTIONARY;

	private DictionaryService(int fileResourceId) {
		initDictionary(fileResourceId);
	}

	private void initDictionary(int fileResourceId) {
		DictionaryReader reader = new DictionaryReader(fileResourceId);
		try {
			DICTIONARY = reader.read();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static DictionaryService getInstance(int fileResourceId) {
		if (service == null) {
			service = new DictionaryService(fileResourceId);
		}
		return service;
	}

	public boolean isWord(String word) {
		return DICTIONARY.hasWord(word);
	}
}
