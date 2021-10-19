package com.bpb.publications.authors.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfigurationAdapter extends WebSecurityConfigurerAdapter {

	//to have 1 user access with hardcoded username and password
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication().withUser("myuser").password("{noop}mypassword").roles("USER");
//	}
//	
//	//to disable security throughout the app
//	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests().antMatchers("*/**").permitAll();
//	}

	//to disable security for particular endpoint, others protected
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests().antMatchers("/author/all").permitAll().anyRequest().authenticated();
//	}

	//to disable security for particular endpoint for oauth mechanism, others protected
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/oauth/token").permitAll().anyRequest().authenticated();
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

}
