package com.antibyteapps.utils;

import com.antibyteapps.services.ClientMode;

/**
 * @author Orhun Dalabasmaz
 */
public class Configuration {
	public static final String ENDPOINT = "http://antibyteapps.orhundalabasmaz.com";
	public static final String SERVICE_PATH = "services/dictionary";

	private static ClientMode CLIENT_MODE = ClientMode.OFFLINE;

	public static void runOffline() {
		CLIENT_MODE = ClientMode.OFFLINE;
	}

	public static void runOnline() {
		CLIENT_MODE = ClientMode.ONLINE;
	}

	public static ClientMode getClientMode() {
		return CLIENT_MODE;
	}
}
