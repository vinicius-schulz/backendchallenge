package br.com.trustly.schulz.backendchallenge.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.trustly.schulz.backendchallenge.dto.ListGitDetailDto;
import br.com.trustly.schulz.backendchallenge.service.GroupedGitDataService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping(value = "git-repository-information")
public class GitRepositoryInformationController {

	@Autowired
	private GroupedGitDataService groupedGitDataService;

	@Operation(summary = "Get Github's Public Repository Details")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Details found", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = ListGitDetailDto.class)) }),
			@ApiResponse(responseCode = "400", description = "Invalid workspace or user repository", content = @Content),
			@ApiResponse(responseCode = "404", description = "Details not found", content = @Content),
			@ApiResponse(responseCode = "500", description = "Unknow error", content = @Content) })
	@GetMapping("/github/{workspace}/{repository}")
	public ResponseEntity<ListGitDetailDto> getGithubRepositoryDetails(@PathVariable String workspace,
			@PathVariable String repository) {
		return ResponseEntity.ok().body(groupedGitDataService.getGithubRepositoryDetails(workspace, repository));
	}
}
