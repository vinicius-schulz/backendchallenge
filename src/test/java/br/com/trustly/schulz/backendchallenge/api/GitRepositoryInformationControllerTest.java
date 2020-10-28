package br.com.trustly.schulz.backendchallenge.api;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.com.trustly.schulz.backendchallenge.dto.ListGitDetailDto;
import br.com.trustly.schulz.backendchallenge.service.SoupGitHubRepositoryInformationService;

@RunWith(MockitoJUnitRunner.class)
public class GitRepositoryInformationControllerTest {

	@Mock
	private SoupGitHubRepositoryInformationService gitHubRepositoryInformationService;

	@InjectMocks
	private GitRepositoryInformationController gitRepositoryInformationController;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getGithubRepositoryDetailsTest() {
		ResponseEntity<ListGitDetailDto> resposta = gitRepositoryInformationController
				.getJSoupGithubRepositoryDetails(Mockito.anyString(), Mockito.anyString());

		assertThat(resposta.getStatusCode()).isEqualTo(HttpStatus.OK);
	}

}
