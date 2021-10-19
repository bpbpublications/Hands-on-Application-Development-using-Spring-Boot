package com.bpb.publications.authors.config;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.bpb.publications.authors.service.interfaces.AppEnvironment;

@Component
@Profile("prod")
//some code for changing properties related with the environment you running  
public class ProdEnvironment implements AppEnvironment {

	@Override
	public String name() {
		return "prod";
	}

}
