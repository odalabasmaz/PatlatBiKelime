package com.antibyteapps.services;

import com.loopj.android.http.TextHttpResponseHandler;

import org.glassfish.jersey.client.ClientConfig;

import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

/**
 * @author Orhun Dalabasmaz
 */
public class ClientService {
	private static final String ENDPOINT = "http://antibyteapps.orhundalabasmaz.com";
	private static final String SERVICE_PATH = "services/dictionary";

	private static ClientService service;
	private static WebTarget target;

	private ClientService() {
		initService();
	}

	public static ClientService getInstance() {
		if (service == null) {
			service = new ClientService();
		}
		return service;
	}

	private void initService() {
		ClientConfig config = new ClientConfig();
		Client client = ClientBuilder.newClient(config);
		target = client.target(getBaseURI());
	}

	private URI getBaseURI() {
		return UriBuilder.fromUri(ENDPOINT).build();
	}

	private String plainRequest(String param) {
		return target.path(SERVICE_PATH).path(param).request().accept(MediaType.TEXT_PLAIN).get(String.class);
	}

	public boolean isWord(String word) {
		return "true".equals(plainRequest(word));
	}

	public void checkWord(String word, TextHttpResponseHandler responseHandler) {
		HttpUtils.get(getFinalServiceUrl(word), responseHandler);
	}

	private String getFinalServiceUrl(String word) {
		return ENDPOINT + "/" + SERVICE_PATH + "/" + word;
	}
}