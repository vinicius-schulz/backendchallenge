package br.com.trustly.schulz.backendchallenge.service.base;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.trustly.schulz.backendchallenge.conversor.CacheConversor;
import br.com.trustly.schulz.backendchallenge.dto.ListGitDetailDto;
import br.com.trustly.schulz.backendchallenge.entity.Cache;
import br.com.trustly.schulz.backendchallenge.entitycomponent.CacheEntityComponent;
import br.com.trustly.schulz.backendchallenge.gitadapter.base.RepositoryAdapter;

/**
 * 
 * @author vinicius.schulz
 *
 */
public abstract class AbstractBaseInformationService {

	@Autowired
	private CacheEntityComponent cacheEntityComponent;

	/**
	 * Generic function to get ListGitDetailDto from any RepositoryAdapter
	 * implementation
	 * 
	 * @return ListGitDetailDto
	 */
	protected ListGitDetailDto getGitRepositoryDetails() {

		try {
			RepositoryAdapter adapter = getGitAdapter();

			String term = adapter.getGitUrl();

			Cache cache = cacheEntityComponent.getCacheFromTerm(term);

			if (cache != null) {
				return CacheConversor.cacheToListGitDetailDto(cache);
			}

			final ListGitDetailDto details = adapter.getListDetails();

			String response = CacheConversor.listGitDetailDtoToJson(details);

			cacheEntityComponent.createCache(term, response);
			return details;
		} catch (IOException e) {
			throw new RuntimeException("Error to get repository", e);
		}

	}

	protected abstract RepositoryAdapter getGitAdapter();

}
