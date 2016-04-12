package com.antibyteapps.utils;

import android.content.res.AssetManager;
import android.content.res.Resources;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Orhun Dalabasmaz
 */
public class FileUtils {
	private static AssetManager ASSET_MANAGER;
	private static Resources RESOURCES;

	public static void setAssetManager(AssetManager assetManager) {
		ASSET_MANAGER = assetManager;
	}

	public static void setResources(Resources resources) {
		RESOURCES = resources;
	}

	/* read from assets */
	public static InputStream readFile(String fileName) throws IOException {
		return ASSET_MANAGER.open(fileName);
	}

	/* read from raw */
	public static InputStream readFile(int resourceId) {
		return RESOURCES.openRawResource(resourceId);
	}
}
