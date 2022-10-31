package com.yash.food.api.entity.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.yash.food.api.entity.Food;

@Service
public interface FoodService {

	public void addFoodItem(Food foodItem);

	public List<Food> getAllFoodItems();
	
	public void deleteFoodItem(int id);

	public List<Food> getFoodItemsByCategory(String category);
	
	
}
