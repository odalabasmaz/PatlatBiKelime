package com.antibyteapps.services;

/**
 * @author Orhun Dalabasmaz
 */
public class ClientServiceFactory {
	private static ClientService localService;
	private static ClientService remoteService;

	private static void initLocalService() {
		if (localService == null) {
			localService = new OfflineClientService();
		}
	}

	private static void initRemoteService() {
		if (remoteService == null) {
			remoteService = new OnlineClientService();
		}
	}

	public static ClientService getClientService(ClientMode clientMode) {
		if (clientMode == ClientMode.OFFLINE) {
			initLocalService();
			return localService;
		} else {
			initRemoteService();
			return remoteService;
		}
	}
}
