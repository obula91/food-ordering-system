package com.yash.food.ordering.admin.api.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.yash.food.ordering.admin.api.entity.Admin;
import com.yash.food.ordering.admin.api.model.Food;
import com.yash.food.ordering.admin.api.service.AdminService;

@SpringBootTest
public class AdminControllerTest {

	@Mock
	private AdminService adminService;
	
	@Mock
	RestTemplate restTemplate;
	
	@InjectMocks
	private AdminController adminController;
	
	private String name="saveAdmin";
	
	Admin admin=new Admin(1, name, name, name);
	
	@Test
	public void testSaveAdmin() throws Exception {
		
	String reponse=	adminController.saveAdmin(admin);
	assertNotEquals("", reponse);
		
	}
	
	@Test
	public void testLoginAdmin() throws Exception {
		Mockito.when(adminService.findAdminByEmailAndPassword(name, name)).thenReturn(admin);
	
		Admin reponse=adminController.loginAdmin(admin);
		
		assertEquals(name, reponse.getAdmin_name());
	}
	
	@Test
	public void testAddFoodItem() {
		Food foodItem=new Food(1, name, name, name, 1, name);
		Mockito.when(restTemplate.postForObject("http://localhost:8003/food/foodItems/", foodItem, String.class)).thenReturn(name);
		String respoonse=adminController.addFoodItem(foodItem);
		
		assertNotEquals("", respoonse);
	}
	
	@Test
	public void testGetAllFoodItems() {
		Food[] foods= {new Food(1, name, name, name, 1, name)};
		Mockito.when(restTemplate.getForEntity("http://localhost:8003/food/foodItems/", Food[].class)).thenReturn(new ResponseEntity<>(foods,HttpStatus.OK));
		Food[] response=adminController.getAllFoodItems();
		assertNotEquals(2, response.length);
	}
	
	@Test
	public void testDeleteFoodItemById() {
		Map<String, Integer> params=new HashMap<>();
		params.put("id", 1);
		//Mockito.when(restTemplate.delete("http://localhost:8003/food/foodItems/{id}", params))
		assertNotEquals("", adminController.deleteFoodItemById(1));
	}
	
	
}
