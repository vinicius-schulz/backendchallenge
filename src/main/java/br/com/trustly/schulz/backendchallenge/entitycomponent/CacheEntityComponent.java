package br.com.trustly.schulz.backendchallenge.entitycomponent;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.trustly.schulz.backendchallenge.entity.Cache;
import br.com.trustly.schulz.backendchallenge.repository.CacheRepository;

@Component
public class CacheEntityComponent {

	@Autowired
	private CacheRepository cacheRepository;

	/**
	 * 
	 * @param term     term used to search
	 * @param response response obtained from git repository processing
	 * @param commitId branch commit id
	 * @return object create from params
	 */
	public Cache createCache(String term, String response, String commitId) {
		Cache cache = new Cache();
		cache.setCommitId(commitId);
		cache.setResponse(response);
		cache.setTerm(term);

		cache = cacheRepository.save(cache);

		return cache;
	}

	/**
	 * 
	 * @param term term used to search
	 * @return persisted cache or null
	 */
	public Cache getLastCacheFromTermAndCommitId(String term, String commitId) {

		Optional<Cache> cacheOpt = cacheRepository.findByTermAndCommitId(term, commitId);
		if (cacheOpt.isPresent()) {
			return cacheOpt.get();
		}
		return null;
	}

}
