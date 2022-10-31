package com.yash.food.api.entity.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yash.food.api.entity.Food;
import com.yash.food.api.entity.service.FoodService;


@RestController
@RequestMapping("/food")
public class FoodController {

	@Autowired
	private FoodService foodService;
     
	@PostMapping("/foodItems")
	public String addFoodItem(@RequestBody Food foodItem) {
		foodService.addFoodItem(foodItem);
		return "Hi admin Food Item " + foodItem.getFood_name() + " Has been addded";
	}

	@GetMapping("/foodItems")
	public List<Food> getAllFoodItems() {
		return foodService.getAllFoodItems();
	}

	@DeleteMapping("/foodItems/{id}")
	public String deleteFoodItemById(@PathVariable("id") int id ) {
		foodService.deleteFoodItem(id);
		return "Item deleted successfully";
	}
	
	@GetMapping("/foodItems/{category}")
	public List<Food> getFoodItemsByCategory(@PathVariable("category") String category) {
		return foodService.getFoodItemsByCategory(category);
	}
}
