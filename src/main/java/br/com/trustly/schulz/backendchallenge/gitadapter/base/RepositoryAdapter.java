package br.com.trustly.schulz.backendchallenge.gitadapter.base;

import java.io.IOException;

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

	public abstract ListGitDetailDto getListDetails() throws IOException;
}
