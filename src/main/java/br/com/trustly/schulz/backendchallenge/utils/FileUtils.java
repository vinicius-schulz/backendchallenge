package br.com.trustly.schulz.backendchallenge.utils;

import com.google.common.io.Files;

/**
 * 
 * @author vinicius.schulz
 *
 */
public final class FileUtils {

	private FileUtils() {

	}

	/**
	 * Utils fuction to get file extension
	 * @param filename file name
	 * @return
	 */
	public static String getExtension(String filename) {
		return Files.getFileExtension(filename);
	}
}
