package com.bpb.publications.authors;  
  
import org.springframework.boot.SpringApplication;  
import org.springframework.boot.autoconfigure.SpringBootApplication;  
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;  
  
@EnableEurekaServer  
@SpringBootApplication  
public class WebServiceEurekaServiceApplication {  
  
    public static void main(String[] args) {  
        SpringApplication.run(WebServiceEurekaServiceApplication.class, args);  
    }  
  
}
