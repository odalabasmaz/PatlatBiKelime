package com.antibyteapps.services;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

/**
 * @author Orhun Dalabasmaz
 */
public class TestWords {
	private static ClientService CLIENT;

	private void initClientService() {
		if (CLIENT == null) {
			CLIENT = ClientService.getInstance();
		}
	}

	@Test
	public void testWordsViaServices() {
		initClientService();
		assertTrue(CLIENT.plainRequest().equals("You should give me a word to check!"));
		assertTrue(CLIENT.plainRequest("aba").equals("true"));
		assertTrue(CLIENT.plainRequest("abaş").equals("false"));
		assertTrue(CLIENT.plainRequest("abay").equals("false"));
		assertTrue(CLIENT.plainRequest("abayı").equals("false"));
		assertTrue(CLIENT.plainRequest("abar").equals("false"));
		assertTrue(CLIENT.plainRequest("abart").equals("false"));
		assertTrue(CLIENT.plainRequest("abartı").equals("true"));
		assertTrue(CLIENT.plainRequest("kalemi").equals("false"));
		assertTrue(CLIENT.plainRequest("atkı").equals("true"));
	}
}
