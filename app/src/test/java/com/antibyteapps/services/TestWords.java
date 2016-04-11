package com.antibyteapps.services;

import org.junit.BeforeClass;
import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.TestCase.assertTrue;

/**
 * @author Orhun Dalabasmaz
 */
public class TestWords {
	private static TestClientService CLIENT;

	private static void initClientService() {
		if (CLIENT == null) {
			CLIENT = TestClientService.getInstance();
		}
	}

	@BeforeClass
	public static void init() {
		initClientService();
	}

	@Test
	public void testWordsViaServices() {
		assertTrue(CLIENT.isWord("aba"));
		assertFalse(CLIENT.isWord("abaş"));
		assertFalse(CLIENT.isWord("abay"));
		assertFalse(CLIENT.isWord("abayı"));
		assertFalse(CLIENT.isWord("abar"));
		assertFalse(CLIENT.isWord("abart"));
		assertTrue(CLIENT.isWord("abartı"));
		assertFalse(CLIENT.isWord("kalemi"));
		assertTrue(CLIENT.isWord("atkı"));
	}
}
