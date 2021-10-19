package com.bpb.publications.authors;  
  
import java.util.Date;  
  
import org.slf4j.Logger;  
import org.slf4j.LoggerFactory;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.boot.CommandLineRunner;  
import org.springframework.stereotype.Component;  
  
import com.bpb.publications.authors.service.AuthorService;  
  
@Component  
public class ApplicationRunner implements CommandLineRunner {  
  
    private static final Logger log = LoggerFactory.getLogger(ApplicationRunner.class);  
  
    @Autowired  
    AuthorService service;  
  
    @Override  
    public void run(String... args) throws Exception {  
        log.info("Loading Data at time :" + new Date());  
        service.loadData();  
        log.info("Loading Data at time :" + new Date());  
        service.loadData();  
        log.info("Loading Data at time :" + new Date());  
        service.loadData();  
        log.info("Loading Data at time :" + new Date());  
        service.loadData();  
        log.info("Loading Data at time :" + new Date());  
        service.loadData();  
    }  
  
}  
