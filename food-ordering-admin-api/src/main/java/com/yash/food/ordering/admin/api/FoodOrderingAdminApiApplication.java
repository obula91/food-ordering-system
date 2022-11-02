package com.yash.food.ordering.admin.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * the class FoodOrderingAdminApiApplication
 * @author obula.reddy
 *
 */
@SpringBootApplication
public class FoodOrderingAdminApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodOrderingAdminApiApplication.class, args);
	}
	
	/**
	 * the getRestTemplate
	 * @return RestTemplate
	 */
	 @Bean
	   public RestTemplate getRestTemplate() {
	      return new RestTemplate();
	   }
}
