package com.bpb.publications.authors.repository;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import com.bpb.publications.authors.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {
	Optional<User> findByUsername(String username);
}
