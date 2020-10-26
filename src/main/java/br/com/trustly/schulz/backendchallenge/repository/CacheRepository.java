package br.com.trustly.schulz.backendchallenge.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.trustly.schulz.backendchallenge.entity.Cache;

/**
 * 
 * @author vinicius.schulz
 *
 */
@Repository
public interface CacheRepository extends JpaRepository<Cache, Long> {

	public Optional<Cache> findByTerm(String term);

}
