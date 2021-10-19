package com.bpb.publications.authors.service;

import java.util.Arrays;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.bpb.publications.authors.entity.Role;
import com.bpb.publications.authors.entity.User;
import com.bpb.publications.authors.repository.RoleRepository;
import com.bpb.publications.authors.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> user = userRepository.findByUsername(username);
		if (user.isPresent()) {
			return user.get();
		} else {
			throw new UsernameNotFoundException("Invalid User :" + username);
		}
	}

	@PostConstruct
	public void postConstruct() {
		if (!userRepository.findByUsername("shagun").isPresent()) {
			Role role = new Role();
			role.setName("ROLE_USER");
			role = roleRepository.save(role);
			User user = new User();
			user.setUsername("shagun");
			user.setPassword(passwordEncoder.encode("sbakliwal"));
			user.setActive(true);
			user.setRoles(Arrays.asList(role));
			userRepository.save(user);
		}
	}

}
