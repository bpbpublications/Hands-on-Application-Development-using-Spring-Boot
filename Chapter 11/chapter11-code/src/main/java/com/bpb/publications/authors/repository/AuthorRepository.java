package com.bpb.publications.authors.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.bpb.publications.authors.entity.Author;

public interface AuthorRepository extends CrudRepository<Author, Integer> {
	Optional<Author> findByNameAndUrl(String name, String url);
}
