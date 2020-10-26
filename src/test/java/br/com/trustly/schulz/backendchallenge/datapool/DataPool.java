package br.com.trustly.schulz.backendchallenge.datapool;

import br.com.trustly.schulz.backendchallenge.entity.Cache;

public final class DataPool {

	private DataPool() {

	}

	public static Cache getCache() {
		Cache cache = new Cache();

		cache.setId(1L);
		cache.setResponse("{" //
				+ "		    \"details\": ["//
				+ "		        {\r\n"//
				+ "		            \"lines\": 10," //
				+ "		            \"size\": 1000,"//
				+ "		            \"extension\": \"java\""//
				+ "		        }]" //
				+ "		}");
		cache.setTerm("https://github.com/vinicius-schulz/backendchallenge");
		return cache;

	}

}
