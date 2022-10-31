package com.yash.food.api.entity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yash.food.api.entity.Food;



@Repository
public interface FoodRepository extends JpaRepository<Food, Integer> {

	List<Food> findByCategory(String category);

}
