package br.com.trustly.schulz.backendchallenge.gitadapter;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.UUID;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;

import br.com.trustly.schulz.backendchallenge.dto.ListGitDetailDto;
import br.com.trustly.schulz.backendchallenge.gitadapter.base.RepositoryAdapter;
import br.com.trustly.schulz.backendchallenge.utils.FileUtils;

/**
 * 
 * @author vinicius.schulz
 *
 */
public class JgitGitHubImplAdapter extends RepositoryAdapter {

	public JgitGitHubImplAdapter(String gitUrl) {
		super(gitUrl);
	}

	@Override
	public ListGitDetailDto getListDetails() {
		try {
			String path = cloneRepository();
			directoryNavigate(path);
			return getDetails();
		} catch (Exception e) {
			throw new RuntimeException("Failed to git information.", e);
		}
	}

	private String cloneRepository() throws GitAPIException {
		String uuid = UUID.randomUUID().toString();
		File file = new File("/repositories/".concat(uuid));
		Git git = Git.cloneRepository().setURI(getGitUrl()).setDirectory(file).call();
		git.close();
		return file.getAbsolutePath();
	}

	private void directoryNavigate(String directoryName) throws IOException {
		File directory = new File(directoryName);
		File[] fList = directory.listFiles();
		if (fList != null) {
			for (File file : fList) {
				if (file.isFile()) {
					readBlob(file);
				} else if (file.isDirectory() && !".git".equals(file.getName())) {
					directoryNavigate(file.getAbsolutePath());
				}
			}
		}
	}

	/**
	 * Function to read github's file blob
	 * 
	 * @param fName file path
	 * @throws IOException
	 */
	private void readBlob(File fName) throws IOException {

		Integer lines = 0;
		try (LineNumberReader reader = new LineNumberReader(new FileReader(fName))) {
			lines = (int) reader.lines().count();
		}

		final String extension = FileUtils.getExtension(fName.getName());
		final Long size = fName.length();

		includeGitDetailDto(extension, size, lines);
	}
}
