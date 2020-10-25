package br.com.trustly.schulz.backendchallenge.service.base;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.trustly.schulz.backendchallenge.dto.ListGitDetailDto;
import br.com.trustly.schulz.backendchallenge.entity.Cache;
import br.com.trustly.schulz.backendchallenge.entitycomponent.CacheEntityComponent;
import br.com.trustly.schulz.backendchallenge.gitadapter.base.GitAdapter;

public abstract class AbstractBaseInformationService {

	@Autowired
	private CacheEntityComponent cacheEntityComponent;

	protected ListGitDetailDto getGitRepositoryDetails() {
		GitAdapter adapter = getGitAdapter();
		
		String term = adapter.getGitUrl();
		String commitId = adapter.getLastCommitId();

		Cache cache = cacheEntityComponent.getLastCacheFromTermAndCommitId(term, commitId);

		cache = cacheEntityComponent.createCache(term, "", "123456789");

		return null;

	}

	protected abstract GitAdapter getGitAdapter();

}
