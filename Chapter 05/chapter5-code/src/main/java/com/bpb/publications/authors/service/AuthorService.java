package com.bpb.publications.authors.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.bpb.publications.authors.model.Author;
import com.bpb.publications.authors.repository.AuthorRepository;

@Service
public class AuthorService {

	private static final Logger log = LoggerFactory.getLogger(AuthorService.class);

	/*@Autowired
	JdbcTemplate jdbcTemplate;

	@PostConstruct	
	public void postConstruct() {
		Author author1 = new Author("Mark", "Shogun");
		Author author2 = new Author("Ruskin", "Handa");
		List<Author> authors = new ArrayList<>();
		authors.add(author1);
		authors.add(author2);
		log.info("Creating tables");
		jdbcTemplate.execute("DROP TABLE author IF EXISTS");
		jdbcTemplate.execute("CREATE TABLE author(" + "id SERIAL, first_name varchar(255), last_name varchar(255))");
		authors.forEach(author -> jdbcTemplate.update("INSERT INTO author(first_name, last_name) VALUES (?,?)",
				author.getFirstName(), author.getLastName()));
		log.info("Records Saved");
		//retrieve saved records.
		log.info("Retrieving records");
		authors = jdbcTemplate.query("select * from author",
				(rs, rowNum) -> new Author(rs.getString("first_name"), rs.getString("last_name")));
		authors.forEach(a -> log.info(a.getFirstName() + " " + a.getLastName()));

	}*/
	
    /*@Autowired  
    AuthorRepository authorRepository;  
    	  
	@PostConstruct  
    public void postConstruct() {  
        Author author = new Author();  
        author.setId(1L);  
        author.setFirstName("Mark");  
        author.setLastName("Shogun");  
        log.info("Performing saving data into database");  
        authorRepository.save(author);  
    	log.info("Retrieve all records");  
        log.info("Authors :" + authors);  
    }
    
    //another version
    @Autowired  
    AuthorRepository authorRepository;  
    @Autowired
	ZipCodeRepository zipCodeRepository;  
  
    
    @PostConstruct  
    public void postConstruct() {  
        Author author = new Author();  
        author.setId(1L);  
        author.setFirstName("Mark");  
        author.setLastName("Shogun");  
        ZipCode zipCode = new ZipCode();  
        zipCode.setCode("400000");  
        zipCodeRepository.save(zipCode);  
        author.setZipCode(zipCode);  
        log.info("Performing saving data into database");  
        authorRepository.save(author);  

        log.info("Retrieve all records");  
        List<Author> authors = authorRepository.findByZipCodeCode("400000");  
        log.info("Authors :" + authors);  
    }
    */  
	  
	@Autowired
	AuthorRepository authorRepository;

	@Cacheable("authors")
	public List<Author> loadData() throws InterruptedException {
		Thread.sleep(3000);
		List<Author> authors = new ArrayList<>();
		authorRepository.findAll().forEach(authors::add);
		return authors;
	}  
}	 