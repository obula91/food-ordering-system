package com.yash.food.orderning.eureka.server.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class FoodOrderningEurekaServerApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodOrderningEurekaServerApiApplication.class, args);
	}

}
