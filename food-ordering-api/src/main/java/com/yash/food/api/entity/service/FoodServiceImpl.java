package com.yash.food.api.entity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.food.api.entity.Food;
import com.yash.food.api.entity.repository.FoodRepository;

@Service
public class FoodServiceImpl implements FoodService {
	
	@Autowired
	private FoodRepository foodRepository;
	
	@Override
	public void addFoodItem(Food foodItem) {
		try {
		foodRepository.save(foodItem);
		}catch(Exception exception) {
			
		}
	}
	@Override
	public List<Food> getAllFoodItems() {
	
		return foodRepository.findAll();
	}
	
	@Override
	public void deleteFoodItem(int id) {
		foodRepository.deleteById(id);
	}
	@Override
	public List<Food> getFoodItemsByCategory(String category) {
		
		return foodRepository.findByCategory(category);
	}
}
