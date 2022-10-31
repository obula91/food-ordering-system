package com.yash.food.ordering.admin.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class FoodOrderingAdminApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodOrderingAdminApiApplication.class, args);
	}

	 @Bean
	   public RestTemplate getRestTemplate() {
	      return new RestTemplate();
	   }
}
