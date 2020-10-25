package br.com.trustly.schulz.backendchallenge.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.trustly.schulz.backendchallenge.entity.base.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@Entity
@ToString
@Table(name = "CACHE")
public class Cache implements BaseEntity<Long> {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;

	@Column(name = "term", nullable = false)
	private String term;

//	@Column(name = "instant", nullable = false)
//	private LocalDateTime instant;

	@Column(name = "response", nullable = true)
	private String response;

	@Column(name = "commit_id", nullable = true)
	private String commitId;
}
