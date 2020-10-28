package br.com.trustly.schulz.backendchallenge.gitadapter.base;

import br.com.trustly.schulz.backendchallenge.dto.GitDetailDto;
import br.com.trustly.schulz.backendchallenge.dto.ListGitDetailDto;
import lombok.Getter;

/**
 * 
 * @author vinicius.schulz
 *
 */
@Getter
public abstract class RepositoryAdapter {

	private final String gitUrl;
	private final ListGitDetailDto details;

	public RepositoryAdapter(String gitUrl) {
		this.gitUrl = gitUrl;
		this.details = new ListGitDetailDto();
	}

	/**
	 * Function to include extension, size and lines into ListGitDetailDto details
	 * 
	 * @param extension file extension
	 * @param size
	 * @param lines
	 */
	protected void includeGitDetailDto(String extension, Long size, Integer lines) {
		Boolean found = false;
		for (GitDetailDto item : details.getDetails()) {
			if (extension.equals(item.getExtension())) {
				item.setLines(item.getLines() + lines);
				item.setSize(item.getSize() + size);
				found = true;
				break;
			}
		}

		if (!found) {
			GitDetailDto detail = new GitDetailDto();
			detail.setExtension(extension);
			detail.setLines(lines);
			detail.setSize(size);
			details.getDetails().add(detail);
		}

	}

	public abstract ListGitDetailDto getListDetails();
}
