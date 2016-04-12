package com.antibyteapps.dictionary.service;

import com.antibyteapps.dictionary.common.DictionaryConstants;
import com.antibyteapps.dictionary.dao.WordDB;
import com.antibyteapps.utils.FileUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * @author Orhun Dalabasmaz
 */
public class DictionaryReader {
	private final int fileResourceId;

	public DictionaryReader(int fileSourceId) {
		this.fileResourceId = fileSourceId;
	}

	public WordDB read() throws IOException {
		WordDB wordDB = new WordDB();
		InputStream inputStream = FileUtils.readFile(fileResourceId);
		Scanner in = new Scanner(inputStream, DictionaryConstants.CHARSET);
		String word;
		while (in.hasNext()) {
			word = in.nextLine();
			wordDB.addWord(word);
		}
		in.close();
		return wordDB;
	}
}
