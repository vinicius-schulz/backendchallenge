package br.com.trustly.schulz.backendchallenge.config;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springdoc.core.GroupedOpenApi;

import io.swagger.v3.oas.models.OpenAPI;

@RunWith(MockitoJUnitRunner.class)
public class SwaggerConfigTest {

	@InjectMocks
	private SwaggerConfig swaggerConfig;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void customOpenApiTest() {
		OpenAPI openAPI = swaggerConfig.customOpenAPI();

		assertThat(openAPI).isNotNull();
	}

	@Test
	public void customApi() {
		GroupedOpenApi groupedOpenApi = swaggerConfig.customApi();

		assertThat(groupedOpenApi).isNotNull();
	}

}
