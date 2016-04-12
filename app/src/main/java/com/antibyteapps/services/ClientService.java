package com.antibyteapps.services;

/**
 * @author Orhun Dalabasmaz
 */
public interface ClientService {
	void checkWord(final String word, final ClientResponseHandler responseHandler);
}
