package br.com.trustly.schulz.backendchallenge.entity.base;

import javax.persistence.MappedSuperclass;

/**
 * 
 * @author vinicius.schulz
 *
 */
@MappedSuperclass
public interface BaseEntity<T> {
	public T getId();

	public void setId(T id);
}
