package br.com.trustly.schulz.backendchallenge.utils;

import com.google.common.io.Files;

public final class FileUtils {

	private FileUtils() {

	}

	public static String getExtension(String filename) {
		return Files.getFileExtension(filename);
	}

	public static String getName(String filename) {
		return Files.getNameWithoutExtension(filename);
	}
}
