package com.antibyteapps.dictionary.analyzer;

import android.util.Log;

import com.antibyteapps.dictionary.common.DictionaryConstants;
import com.antibyteapps.utils.Constants;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Orhun Dalabasmaz
 */
public class WordAnalyzer {
	private Map<Character, Integer> frequencyMap;

	public WordAnalyzer() {
		this.frequencyMap = new LinkedHashMap<>();
		initMap();
	}

	private void initMap() {
		for (Character ch : Constants.ALPHABET
				.toLowerCase(DictionaryConstants.LOCALE_TR)
				.toCharArray()) {
			frequencyMap.put(ch, 0);
		}
	}

	public void analyze(String word) {
		if (word == null || word.isEmpty()) return;
		for (char ch : word.toCharArray()) {
			Integer freq = frequencyMap.get(ch);
			if (freq == null) {
				Log.d("OUT", ">>>> " + word + " - " + ch);
				continue;
			}
			frequencyMap.put(ch, freq + 1);
		}
	}

	public Map<Character, Integer> getFrequencyMap() {
		return frequencyMap;
	}

	public void setFrequencyMap(Map<Character, Integer> frequencyMap) {
		this.frequencyMap = frequencyMap;
	}

	public String printFrequencies() {
		StringBuilder sb = new StringBuilder();
		for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
			Character key = entry.getKey();
			Integer value = entry.getValue();
			sb.append("{").append(key).append(":").append(value).append("}");
		}
		return sb.toString();
	}
}
