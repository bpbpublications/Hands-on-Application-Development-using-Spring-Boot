package com.bpb.publications.authors.controller;

import static org.mockito.ArgumentMatchers.anyObject;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.bpb.publications.authors.advice.AppControllerAdvice;
import com.bpb.publications.authors.exception.NoRecordsException;
import com.bpb.publications.authors.repository.AuthorRepository;
import com.bpb.publications.authors.service.AuthorService;

class AuthorControllerTest {

	@InjectMocks
	AuthorController authorController;

	@Mock
	AuthorService authorService;

	MockMvc mockMvc;

	@InjectMocks
	AppControllerAdvice advice;

	@Mock
	AuthorRepository authorRepository;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(authorController).setControllerAdvice(advice).build();
	}

	@Test
	void addAuthorTests() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/author/add")
				.content("{\"bio\":\"this is my bio\",\"name\": \"John Mark\",\"url\": \"www.johnmark.com\"}" + "")
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andReturn();
		Mockito.verify(authorService, Mockito.times(1)).add(anyObject());
		Mockito.verifyNoMoreInteractions(authorService);
	}

	@Test
	void getAuthorTest() throws Exception {
		MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
		queryParams.add("name", "shagun");
		queryParams.add("url", "url");
		when(authorService.get(anyString(), anyString())).thenThrow(NoRecordsException.class);
		mockMvc.perform(MockMvcRequestBuilders.get("/author").queryParams(queryParams))
				.andExpect(status().isNotFound());

	}

}
