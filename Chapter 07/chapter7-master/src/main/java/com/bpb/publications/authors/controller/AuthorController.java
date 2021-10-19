package com.bpb.publications.authors.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Positive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.bpb.publications.authors.exception.ErrorMessage;
import com.bpb.publications.authors.service.AuthorService;
import com.bpb.publications.authors.vo.AuthorVO;

import lombok.extern.slf4j.Slf4j;

@Validated
@RestController
@RequestMapping("/author")
@Slf4j
public class AuthorController {

	@Autowired
	AuthorService authorService;

	@RequestMapping(method = RequestMethod.GET, name = "Get Author By Name and URL", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getAuthor(@RequestParam(name = "name") String name,
			@RequestParam(name = "url") String url) {
		try {
			return new ResponseEntity<>(authorService.get(name, url), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(new ErrorMessage(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(name = "Get Author By ID", value = "/{id}")
	public ResponseEntity<?> getAuthorById(@PathVariable @Positive(message = "Invalid ID") int id) {
		//try {
			return new ResponseEntity<>(authorService.findById(id), HttpStatus.OK);
		/*} catch (Exception e) {
			return new ResponseEntity<>(new ErrorMessage(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}*/
	}

	@PostMapping(name = "Add Author", value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> addAuthor(@RequestBody @Valid AuthorVO authorVO) {
		try {
			return new ResponseEntity<>(authorService.add(authorVO), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(new ErrorMessage(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

	@GetMapping(name = "Get Authors", value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getAuthors() {
		try {
			return new ResponseEntity<>(authorService.getAll(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(new ErrorMessage(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@Autowired  
	private RestTemplate restTemplate;  
	  
	@GetMapping(name = "Call API using RestTemplate", value = "/callAPI", produces = MediaType.APPLICATION_JSON_VALUE)  
	public ResponseEntity<?> callAPIUsingRestTemplate() throws URISyntaxException {  
	  
	    ResponseEntity<String> plainResponse = restTemplate  
	            .exchange(RequestEntity.get(new URI("http://localhost:8081/author/all")).build(), String.class);  
	    log.info("Received Plain response from '/all' API :{}", plainResponse.getBody());  
	  
	    AuthorVO authorVO = new AuthorVO();  
	    authorVO.setUrl("url-called for PostForEntity /callAPI");  
	    authorVO.setName("name-called for PostForEntity /callAPI");  
	    authorVO.setBio("bio-called for PostForEntity /callAPI");  
	    ResponseEntity<Boolean> booleanResponse = restTemplate  
	            .postForEntity(new URI("http://localhost:8081/author/add"), authorVO, Boolean.class);  
	    log.info("Received response from POST API '/add' (PostForEntity):{}", booleanResponse.getBody());  
	  
	    AuthorVO authorVO1 = new AuthorVO();  
	    authorVO1.setUrl("url-called for Exchange /callAPI");  
	    authorVO1.setName("name-called for Exchange /callAPI");  
	    authorVO1.setBio("bio-called for Exchange /callAPI");  
	    HttpHeaders headers = new HttpHeaders();  
	    headers.add("key1", "value1");  
	    HttpEntity<AuthorVO> httpEntity = new HttpEntity<>(authorVO1, headers);  
	    ResponseEntity<Boolean> booleanResponse1 = restTemplate.exchange(new URI("http://localhost:8081/author/add"),  
	            HttpMethod.POST, httpEntity, Boolean.class);  
	    log.info("Received response from POST API '/add' (Exchange) :{}", booleanResponse1.getBody());  
	  
	    ResponseEntity<List> pojoResponse = restTemplate  
	            .exchange(RequestEntity.get(new URI("http://localhost:8081/author/all")).build(), List.class);  
	  
	    log.info("Received POJO response from '/all' API :{}", pojoResponse.getBody());  
	    return new ResponseEntity<>(null, HttpStatus.OK);  
	}


}
