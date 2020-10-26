package br.com.trustly.schulz.backendchallenge.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

/**
 * 
 * @author vinicius.schulz
 *
 */
@Data
@JsonInclude(Include.NON_NULL)
public class ListGitDetailDto {
	private List<GitDetailDto> details;

	public ListGitDetailDto() {
		details = new ArrayList<>();
	}
}
