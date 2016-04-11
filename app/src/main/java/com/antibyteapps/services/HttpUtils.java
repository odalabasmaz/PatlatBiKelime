package com.antibyteapps.services;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

/**
 * @author Orhun Dalabasmaz
 */
public class HttpUtils {
	private static final AsyncHttpClient client = new AsyncHttpClient();

	public static void get(String url, AsyncHttpResponseHandler responseHandler) {
		client.get(url, responseHandler);
	}

	public static void get(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
		client.get(url, params, responseHandler);
	}

	public static void post(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
		client.post(url, params, responseHandler);
	}

	public static void getByUrl(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
		client.get(url, params, responseHandler);
	}

	public static void postByUrl(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
		client.post(url, params, responseHandler);
	}
}
