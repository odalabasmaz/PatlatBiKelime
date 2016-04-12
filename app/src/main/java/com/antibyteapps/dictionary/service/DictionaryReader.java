package com.antibyteapps.dictionary.service;

import com.antibyteapps.dictionary.analyzer.WordAnalyzer;
import com.antibyteapps.dictionary.common.DictionaryConstants;
import com.antibyteapps.dictionary.dao.WordDB;
import com.antibyteapps.utils.FileUtils;
import com.antibyteapps.utils.WordUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * @author Orhun Dalabasmaz
 */
public class DictionaryReader {
	private final int fileResourceId;
	private final WordAnalyzer wordAnalyzer;

	public DictionaryReader(int fileSourceId, WordAnalyzer wordAnalyzer) {
		this.fileResourceId = fileSourceId;
		this.wordAnalyzer = wordAnalyzer;
	}

	public WordDB createDB() throws IOException {
		WordDB wordDB = new WordDB();
		InputStream inputStream = FileUtils.readFile(fileResourceId);
		Scanner in = new Scanner(inputStream, DictionaryConstants.CHARSET);
		String word;
		while (in.hasNext()) {
			word = in.nextLine();
			if (!WordUtils.isRegularWord(word)) continue;
			word = WordUtils.format(word);
//			if (wordDB.hasWord(word)) continue;
			wordDB.addWord(word);
//			wordAnalyzer.analyze(word);
		}
		in.close();
		return wordDB;
	}
}
