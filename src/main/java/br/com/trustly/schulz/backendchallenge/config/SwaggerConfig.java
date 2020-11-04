package br.com.trustly.schulz.backendchallenge.config;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;

/**
 * 
 * @author vinicius.schulz
 *
 */
@Configuration
public class SwaggerConfig {

	@Value("${spring.application.name}")
	private String applicationName;

	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI().addServersItem(new Server().url("/"))
				.info(new Info().title("Trustly Technical Challenge for Developers").version("1.0.0").description(
						"API that returns the total number of lines and the total number of bytes of all the\r\n"
								+ "files of a given public Github repository, grouped by file extension."));
	}

	@Bean
	public GroupedOpenApi customApi() {
		return GroupedOpenApi.builder().group("api").pathsToMatch("/**").build();
	}
}
