package br.com.trustly.schulz.backendchallenge.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author vinicius.schulz
 *
 */
@Data
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class GitDetailDto {
	private Integer lines = 0;
	private Long size = 0L;
	private String extension = "";
}
