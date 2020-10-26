package br.com.trustly.schulz.backendchallenge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.trustly.schulz.backendchallenge.dto.ListGitDetailDto;
import br.com.trustly.schulz.backendchallenge.gitadapter.GitHubImplAdapter;
import br.com.trustly.schulz.backendchallenge.gitadapter.base.RepositoryAdapter;
import br.com.trustly.schulz.backendchallenge.service.base.AbstractBaseInformationService;

@Service
public class GitHubRepositoryInformationService extends AbstractBaseInformationService {

	private String workspace;
	private String repository;

	@Autowired
	public GitHubRepositoryInformationService() {
		super();
	}

	@Transactional
	public ListGitDetailDto getGithubRepositoryDetails(String workspace, String repository) {

		this.workspace = workspace;
		this.repository = repository;

		return getGitRepositoryDetails();
	}

	@Override
	protected RepositoryAdapter getGitAdapter() {
		return new GitHubImplAdapter("https://github.com/".concat(workspace).concat("/").concat(repository));
	}

}
