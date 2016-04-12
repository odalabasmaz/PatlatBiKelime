package com.antibyteapps.services;

import com.antibyteapps.dictionary.service.DictionaryService;
import com.antibyteapps.patlatbikelime.R;

/**
 * @author Orhun Dalabasmaz
 */
public class OfflineClientService extends BaseClientService implements ClientService {
	private DictionaryService localService;

	public OfflineClientService() {
		localService = new DictionaryService(R.raw.words, wordAnalyzer);
	}

	@Override
	public void checkWord(final String word, final ClientResponseHandler responseHandler) {
		boolean isWord = localService.isWord(word);
		responseHandler.onResponse(isWord);
	}
}
