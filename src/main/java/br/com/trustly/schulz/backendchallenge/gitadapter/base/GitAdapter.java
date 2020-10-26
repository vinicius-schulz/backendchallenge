package br.com.trustly.schulz.backendchallenge.gitadapter.base;

import lombok.Getter;

@Getter
public abstract class GitAdapter {

	private final String gitUrl;
	private final String branch;

	public GitAdapter(String gitUrl, String branch) {
		this.gitUrl = gitUrl;
		this.branch = branch;
	}
}
