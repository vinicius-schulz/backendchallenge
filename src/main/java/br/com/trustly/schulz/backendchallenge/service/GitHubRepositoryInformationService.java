package br.com.trustly.schulz.backendchallenge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.trustly.schulz.backendchallenge.dto.ListGitDetailDto;
import br.com.trustly.schulz.backendchallenge.entitycomponent.CacheEntityComponent;
import br.com.trustly.schulz.backendchallenge.gitadapter.GitHubImplAdapter;
import br.com.trustly.schulz.backendchallenge.gitadapter.base.GitAdapter;
import br.com.trustly.schulz.backendchallenge.service.base.AbstractBaseInformationService;

@Service
public class GitHubRepositoryInformationService extends AbstractBaseInformationService {

	private final CacheEntityComponent cacheEntityComponent;
	private String workspace;
	private String repository;

	@Autowired
	public GitHubRepositoryInformationService(CacheEntityComponent cacheEntityComponent) {
		super();
		this.cacheEntityComponent = cacheEntityComponent;
	}

	@Transactional
	public ListGitDetailDto getGithubRepositoryDetails(String workspace, String repository) {

		this.workspace = workspace;
		this.repository = repository;

		super.getGitRepositoryDetails();

		return null;
	}

	@Override
	protected GitAdapter getGitAdapter() {
		return new GitHubImplAdapter(
				"https://github.com/".concat(workspace).concat("/").concat(repository).concat(".git'"));
	}

}
