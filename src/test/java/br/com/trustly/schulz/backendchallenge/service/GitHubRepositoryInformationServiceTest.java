package br.com.trustly.schulz.backendchallenge.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import br.com.trustly.schulz.backendchallenge.datapool.DataPool;
import br.com.trustly.schulz.backendchallenge.dto.ListGitDetailDto;
import br.com.trustly.schulz.backendchallenge.entity.Cache;
import br.com.trustly.schulz.backendchallenge.entitycomponent.CacheEntityComponent;

@RunWith(MockitoJUnitRunner.class)
public class GitHubRepositoryInformationServiceTest {

	@Mock
	private CacheEntityComponent cacheEntityComponent;

	@InjectMocks
	private SoupGitHubRepositoryInformationService gitHubRepositoryInformationService;

	Cache cache;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		cache = DataPool.getCache();
	}

	@Test
	public void getGithubRepositoryDetailsWithCacheNonNullTest() {

		Mockito.doReturn(this.cache).when(cacheEntityComponent).getCacheFromTerm(Mockito.anyString());

		ListGitDetailDto details = gitHubRepositoryInformationService.getGithubRepositoryDetails("", "");

		assertThat(details).isNotNull();
	}
}
