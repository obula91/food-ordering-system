package com.yash.food.orderning.cloud.config.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class FoodOrderningCloudConfigApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodOrderningCloudConfigApiApplication.class, args);
	}

}
