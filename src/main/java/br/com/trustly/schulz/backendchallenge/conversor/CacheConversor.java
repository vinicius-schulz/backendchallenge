package br.com.trustly.schulz.backendchallenge.conversor;

import com.google.gson.Gson;

import br.com.trustly.schulz.backendchallenge.dto.ListGitDetailDto;
import br.com.trustly.schulz.backendchallenge.entity.Cache;

public final class CacheConversor {

	private CacheConversor() {
	}

	/**
	 * 
	 * @param cache object that will be converted
	 * @return converted object
	 */
	public static ListGitDetailDto cacheToListGitDetailDto(Cache cache) {
		Gson gson = new Gson();
		return gson.fromJson(cache.getResponse(), ListGitDetailDto.class);
	}

	/**
	 * 
	 * @param details object with the list that will be converted
	 * @return json from ListGitDetailDto
	 */
	public static String listGitDetailDtoToJson(ListGitDetailDto details) {
		Gson gson = new Gson();
		return gson.toJson(details);
	}
}
