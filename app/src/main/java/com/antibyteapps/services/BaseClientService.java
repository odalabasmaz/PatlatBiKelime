package com.antibyteapps.services;

import com.antibyteapps.dictionary.analyzer.WordAnalyzer;

/**
 * @author Orhun Dalabasmaz
 */
public abstract class BaseClientService {
	protected WordAnalyzer wordAnalyzer;

	protected BaseClientService() {
		this.wordAnalyzer = new WordAnalyzer();
	}
}
