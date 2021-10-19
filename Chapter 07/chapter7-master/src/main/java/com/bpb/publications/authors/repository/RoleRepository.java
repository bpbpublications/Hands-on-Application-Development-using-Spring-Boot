package com.bpb.publications.authors.repository;

import org.springframework.data.repository.CrudRepository;

import com.bpb.publications.authors.entity.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {

}
