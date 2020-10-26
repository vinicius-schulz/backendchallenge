package br.com.trustly.schulz.backendchallenge.utils;

import java.io.File;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.UUID;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;

public final class GitUtils {

	private GitUtils() {

	}

	public static Path cloneBranch(String url, String branch) throws GitAPIException {

		final String folder = UUID.randomUUID().toString();
		final File path = new File("./repositories/".concat(folder));
		Git.cloneRepository().setURI(url).setDirectory(path)
				.setBranchesToClone(Arrays.asList("refs/heads/".concat(branch))).setBranch("refs/heads/".concat(branch))
				.call();
		return path.toPath();
	}

}
