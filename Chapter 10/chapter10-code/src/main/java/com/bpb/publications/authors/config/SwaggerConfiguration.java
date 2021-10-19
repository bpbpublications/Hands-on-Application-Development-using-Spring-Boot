package com.bpb.publications.authors.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfiguration {

	/*@Bean
	public Docket apisForSpecificPackage() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.bpb.publications.authors")).build();
	}*/
	
	 @Bean  
	 public Docket api() {  
	     return new Docket(DocumentationType.SWAGGER_2)  
	             .select()  
	             .apis(RequestHandlerSelectors.any())  
	             .paths(PathSelectors.any())  
	             .build()  
	             .apiInfo(apiInfo());  
	 } 

	 private ApiInfo apiInfo() {  
	     return new ApiInfo(  
	             "Web Service for Authors",   
	             "The project contains APIs for managing Authors Information",   
	             "API v1",  
	             "These are my terms of service",  
	             new Contact("Developer", "www.webaddress.com", "abcd@emailprovider.com"),   
	             "This is the license of API",  
	             "www.mylicencekey.com",   
	             Collections.emptyList());  
	 }  


}
