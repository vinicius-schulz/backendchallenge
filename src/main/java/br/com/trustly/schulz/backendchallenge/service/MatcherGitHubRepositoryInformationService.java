package br.com.trustly.schulz.backendchallenge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.trustly.schulz.backendchallenge.dto.ListGitDetailDto;
import br.com.trustly.schulz.backendchallenge.gitadapter.MatcherGitHubImplAdapter;
import br.com.trustly.schulz.backendchallenge.gitadapter.base.RepositoryAdapter;
import br.com.trustly.schulz.backendchallenge.service.base.AbstractBaseInformationService;

/**
 * 
 * @author vinicius.schulz
 *
 */
@Service
public class MatcherGitHubRepositoryInformationService extends AbstractBaseInformationService {

	private String workspace;
	private String repository;

	@Autowired
	public MatcherGitHubRepositoryInformationService() {
		super();
	}

	/**
	 * Fuction to get ListGitDetailDto from workspace and repository
	 * 
	 * @param workspace  workspace identifier
	 * @param repository repository name
	 * @return
	 */
	@Transactional
	public ListGitDetailDto getGithubRepositoryDetails(String workspace, String repository) {

		this.workspace = workspace;
		this.repository = repository;

		return getGitRepositoryDetails();
	}

	/**
	 * Fuction to build github's url from workspace and repository.
	 */
	@Override
	protected RepositoryAdapter getGitAdapter() {
		return new MatcherGitHubImplAdapter("https://github.com/".concat(workspace).concat("/").concat(repository));
	}

}
