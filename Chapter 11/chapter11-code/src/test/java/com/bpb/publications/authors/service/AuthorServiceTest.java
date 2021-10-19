package com.bpb.publications.authors.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.bpb.publications.authors.entity.Author;
import com.bpb.publications.authors.repository.AuthorRepository;
import com.bpb.publications.authors.vo.AuthorVO;

@ExtendWith(MockitoExtension.class)  
class AuthorServiceTest {

	@InjectMocks  
    AuthorService authorService;  
	@Mock
	AuthorRepository authorRepository;

	Author author;  

    @BeforeEach  
    void setUp() throws Exception {  
        //authorService = new AuthorService();
    	MockitoAnnotations.initMocks(this);  
        author = new Author();  
        author.setId(1);  
        author.setName("Shagun");  
    }

	/*@Test
	void test() {
		Assertions.assertEquals(3, authorService.sum(1, 2));
	}*/
    
	/*@Test
	void findByIdTest() {
		authorService.authorRepository = Mockito.mock(AuthorRepository.class);
		Mockito.when(authorService.authorRepository.findById(Mockito.any())).thenReturn(Optional.of(author));
		Assertions.assertEquals("Shagun", authorService.findById(1).getName());
		Mockito.verify(authorService.authorRepository).findById(1);
	}*/
    
    @Test  
    void findByIdTest() {  
        Mockito.when(authorRepository.findById(Mockito.any())).thenReturn(Optional.of(author));  
        Assertions.assertEquals("Shagun", authorService.findById(1).getName());  
        Mockito.verify(authorRepository).findById(1);  
        Mockito.verify(authorRepository, Mockito.times(1)).findById(1);  
    }  

	@Test
	void getAllAuthorsTest() throws Exception {
		author = new Author();
		author.setId(1);
		author.setName("Shagun");

		// given
		BDDMockito.given(authorRepository.findAll()).willReturn(Collections.singleton(author));

		// when
		List<AuthorVO> response = authorService.getAll();

		// then
		Assertions.assertEquals(1, response.size());
		Assertions.assertEquals("Shagun", response.get(0).getName());
	}

}
