package br.com.trustly.schulz.backendchallenge.gitadapter.base;

import lombok.Getter;

@Getter
public abstract class GitAdapter {

	private final String gitUrl;

	public GitAdapter(String gitUrl) {
		this.gitUrl = gitUrl;

	}

	public abstract String getLastCommitId();
}
