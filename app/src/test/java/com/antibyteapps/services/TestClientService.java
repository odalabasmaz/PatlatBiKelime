package com.antibyteapps.services;

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
public class TestClientService {
	private static final String ENDPOINT = "http://antibyteapps.orhundalabasmaz.com";
	private static final String ENDPOINT_LOCAL = "http://wrkodalabasmaz:8080";
	private static final String SERVICES = "services";
	private static final String SERVICE_PATH = "dictionary";

	private static TestClientService service;
	private static WebTarget target;

	private TestClientService() {
		initService();
	}

	public static TestClientService getInstance() {
		if (service == null) {
			service = new TestClientService();
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

	private String plainRequest() {
		return target.path(SERVICES).path(SERVICE_PATH).request().accept(MediaType.TEXT_PLAIN).get(String.class);
	}

	private String plainRequest(String param) {
		return target.path(SERVICES).path(SERVICE_PATH).path(param).request().accept(MediaType.TEXT_PLAIN).get(String.class);
	}

	public boolean isWord(String word) {
		return "true".equals(plainRequest(word));
	}
}
