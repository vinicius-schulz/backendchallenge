package br.com.trustly.schulz.backendchallenge.service.base;

import java.io.IOException;
import java.nio.file.Path;

import org.eclipse.jgit.api.errors.GitAPIException;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.trustly.schulz.backendchallenge.conversor.CacheConversor;
import br.com.trustly.schulz.backendchallenge.dto.ListGitDetailDto;
import br.com.trustly.schulz.backendchallenge.entity.Cache;
import br.com.trustly.schulz.backendchallenge.entitycomponent.CacheEntityComponent;
import br.com.trustly.schulz.backendchallenge.gitadapter.base.GitAdapter;
import br.com.trustly.schulz.backendchallenge.utils.FileUtils;
import br.com.trustly.schulz.backendchallenge.utils.GitUtils;

public abstract class AbstractBaseInformationService {

	@Autowired
	private CacheEntityComponent cacheEntityComponent;

	protected ListGitDetailDto getGitRepositoryDetails() throws GitAPIException, IOException {
		GitAdapter adapter = getGitAdapter();

		String term = adapter.getGitUrl();
		String branch = adapter.getBranch();

		Cache cache = cacheEntityComponent.getCacheFromTermAndBranch(term, branch);

		if (cache != null) {
			return CacheConversor.cacheToListGitDetailDto(cache);
		}

		Path path = GitUtils.cloneBranch(term, branch);

		FileUtils.deleteDirectoryStream(path);

		cache = cacheEntityComponent.createCache(term, "", branch);

		return null;

	}

	protected abstract GitAdapter getGitAdapter();

}
