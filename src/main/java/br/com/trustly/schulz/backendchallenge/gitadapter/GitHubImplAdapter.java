package br.com.trustly.schulz.backendchallenge.gitadapter;

import br.com.trustly.schulz.backendchallenge.gitadapter.base.GitAdapter;

public class GitHubImplAdapter extends GitAdapter {

	public GitHubImplAdapter(String gitUrl) {
		super(gitUrl);
	}

	@Override
	public String getLastCommitId() {
		return "123456789";
	}

}
