package com.antibyteapps.services;

import com.antibyteapps.dictionary.service.DictionaryService;
import com.antibyteapps.patlatbikelime.R;

/**
 * @author Orhun Dalabasmaz
 */
public class OfflineClientService implements ClientService {
	private static DictionaryService localService = DictionaryService.getInstance(R.raw.words);

	@Override
	public void checkWord(final String word, final ClientResponseHandler responseHandler) {
		boolean isWord = localService.isWord(word);
		responseHandler.onResponse(isWord);
	}
}
