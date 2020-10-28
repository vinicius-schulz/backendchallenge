package br.com.trustly.schulz.backendchallenge.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.trustly.schulz.backendchallenge.dto.ListGitDetailDto;
import br.com.trustly.schulz.backendchallenge.service.GitHubRepositoryInformationService;
import br.com.trustly.schulz.backendchallenge.service.JgitGitHubRepositoryInformationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * 
 * @author vinicius.schulz
 *
 */
@RestController
@RequestMapping(value = "git-repository-information")
@Tag(name = "git-repository", description = "Git's repository information API")
public class GitRepositoryInformationController {

	@Autowired
	private GitHubRepositoryInformationService gitHubRepositoryInformationService;
	
	@Autowired
	private JgitGitHubRepositoryInformationService jgitGitHubRepositoryInformationService;
	

	@Operation(summary = "Get github's public repository information", description = "Github's repository information by workspace and repository")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Details found", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = ListGitDetailDto.class)) }),
			@ApiResponse(responseCode = "400", description = "Invalid workspace or user repository", content = @Content),
			@ApiResponse(responseCode = "404", description = "Details not found", content = @Content),
			@ApiResponse(responseCode = "500", description = "Unknow error", content = @Content) })

	@GetMapping(value = "/github/{workspace}/{repository}", produces = "application/json")
	public ResponseEntity<ListGitDetailDto> getGithubRepositoryDetails(
			@Parameter(description = "Gihub's workspace identifier", example = "vinicius-schulz") @PathVariable(required = true) String workspace,
			@Parameter(description = "Gihub's repository identifier", example = "backendchallenge") @PathVariable(required = true) String repository) {
		return ResponseEntity.ok()
				.body(gitHubRepositoryInformationService.getGithubRepositoryDetails(workspace, repository));
	}
	
	@GetMapping(value = "/{workspace}/{repository}", produces = "application/json")
	public ResponseEntity<ListGitDetailDto> getGitGithubRepositoryDetails(
			@Parameter(description = "Gihub's workspace identifier", example = "vinicius-schulz") @PathVariable(required = true) String workspace,
			@Parameter(description = "Gihub's repository identifier", example = "backendchallenge") @PathVariable(required = true) String repository) {
		return ResponseEntity.ok()
				.body(jgitGitHubRepositoryInformationService.getGithubRepositoryDetails(workspace, repository));
	}
}
