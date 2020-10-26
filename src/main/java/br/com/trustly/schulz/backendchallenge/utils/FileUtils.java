package br.com.trustly.schulz.backendchallenge.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.stream.Stream;

public final class FileUtils {

	private FileUtils() {

	}

	public static void deleteDirectoryStream(Path path) throws IOException {
		try (Stream<Path> paths = Files.walk(path)) {
			paths.sorted(Comparator.reverseOrder()).map(Path::toFile).forEach(File::delete);
		}
	}
}
