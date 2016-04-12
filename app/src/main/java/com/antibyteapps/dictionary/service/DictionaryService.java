package com.antibyteapps.dictionary.service;

import android.util.Log;

import com.antibyteapps.dictionary.analyzer.WordAnalyzer;
import com.antibyteapps.dictionary.dao.WordDB;

/**
 * @author Orhun Dalabasmaz
 */
public class DictionaryService {
	private WordDB wordDB;

	public DictionaryService(int fileResourceId, WordAnalyzer wordAnalyzer) {
		initDictionary(fileResourceId, wordAnalyzer);
	}

	private void initDictionary(int fileResourceId, WordAnalyzer wordAnalyzer) {
		DictionaryReader reader = new DictionaryReader(fileResourceId, wordAnalyzer);
		try {
			long begin = System.currentTimeMillis();
			wordDB = reader.createDB();
			long end = System.currentTimeMillis();
			long duration = (end - begin) / 1000;
			Log.d("OUT", "DB created in: " + duration + "sec");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean isWord(String word) {
		return wordDB.hasWord(word);
	}
}
