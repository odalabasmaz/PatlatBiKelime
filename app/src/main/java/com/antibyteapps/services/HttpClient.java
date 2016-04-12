package com.antibyteapps.services;

import com.antibyteapps.utils.Configuration;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

/**
 * @author Orhun Dalabasmaz
 */
public class HttpClient {
	private static final AsyncHttpClient HTTP_CLIENT = new AsyncHttpClient();

	public static void get(String word, AsyncHttpResponseHandler responseHandler) {
		HTTP_CLIENT.get(getFinalServiceUrl(word), responseHandler);
	}

	public static void get(String word, RequestParams params, AsyncHttpResponseHandler responseHandler) {
		HTTP_CLIENT.get(getFinalServiceUrl(word), params, responseHandler);
	}

	public static void post(String word, RequestParams params, AsyncHttpResponseHandler responseHandler) {
		HTTP_CLIENT.post(getFinalServiceUrl(word), params, responseHandler);
	}

	public static void getByUrl(String word, RequestParams params, AsyncHttpResponseHandler responseHandler) {
		HTTP_CLIENT.get(getFinalServiceUrl(word), params, responseHandler);
	}

	public static void postByUrl(String word, RequestParams params, AsyncHttpResponseHandler responseHandler) {
		HTTP_CLIENT.post(getFinalServiceUrl(word), params, responseHandler);
	}

	private static String getFinalServiceUrl(String word) {
		return Configuration.ENDPOINT + "/" + Configuration.SERVICE_PATH + "/" + word;
	}
}
