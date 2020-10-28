package br.com.trustly.schulz.backendchallenge.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.stream.Stream;

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
	 * 
	 * @param filename file name
	 * @return
	 */
	public static String getExtension(String filename) {
		return com.google.common.io.Files.getFileExtension(filename);
	}

	public static void deleteDirectoryStream(Path path) throws IOException {
		try (Stream<Path> streamPath = Files.walk(path)) {
			streamPath.sorted(Comparator.reverseOrder()).map(Path::toFile).forEach(File::delete);
		}
	}
}
