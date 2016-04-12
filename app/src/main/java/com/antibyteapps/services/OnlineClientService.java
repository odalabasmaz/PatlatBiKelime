package com.antibyteapps.services;

import com.loopj.android.http.TextHttpResponseHandler;

import cz.msebera.android.httpclient.Header;

/**
 * @author Orhun Dalabasmaz
 */
public class OnlineClientService implements ClientService {
	@Override
	public void checkWord(final String word, final ClientResponseHandler responseHandler) {
		HttpClient.get(word, getHttpResponseHandler(responseHandler));
	}

	private TextHttpResponseHandler getHttpResponseHandler(final ClientResponseHandler responseHandler) {
		return new TextHttpResponseHandler() {
			@Override
			public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {

			}

			@Override
			public void onSuccess(int statusCode, Header[] headers, String responseString) {
				boolean isWord = "true".equals(responseString);
				responseHandler.onResponse(isWord);
			}
		};
	}
}
