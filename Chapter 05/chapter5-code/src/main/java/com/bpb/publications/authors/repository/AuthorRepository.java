package com.bpb.publications.authors.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bpb.publications.authors.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {
	List<Author> findByFirstName(String name);

	List<Author> findByZipCodeCode(String code);
}
