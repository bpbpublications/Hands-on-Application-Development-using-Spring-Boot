package com.author.kickstart.configuration;  
  
import org.springframework.context.annotation.Profile;  
import org.springframework.stereotype.Component;  
  
@Component  
@Profile({"dev","qa"})  
public class NonProdDatabaseConfig {  
	public NonProdDatabaseConfig(){
		System.out.println("non-prod");
	}
}  
