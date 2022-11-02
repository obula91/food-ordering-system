package com.yash.food.api.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FoodTest {

	private String name="name";
	@Test
	public void testFood() {
		Food food=new Food();
		Food foodOne=new Food(1, name, name, name, 1, name);
		food.setCategory(name);
		food.setFood_description(name);
		food.setFood_id(1);
		food.setFood_image(name);
		food.setPrice(1);
		food.getCategory();
		food.getFood_id();
		food.getFood_image();
		food.getFood_name();
		food.getPrice();
		food.setFood_name(name);
		food.getFood_description();
		foodOne.toString();
		assertEquals(name, foodOne.getFood_name());
	}
}
