package com.yash.food.ordering.admin.api.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.yash.food.ordering.admin.api.entity.Admin;
import com.yash.food.ordering.admin.api.model.Food;
import com.yash.food.ordering.admin.api.service.AdminService;



@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private RestTemplate restTemplate;

	@PostMapping("/register")
	public String saveAdmin(@RequestBody Admin admin) throws Exception {
		String tempEmail = admin.getAdmin_email();

		if (tempEmail != null && !"".equals(tempEmail)) {
			Admin adminObjectFromDb = adminService.findAdminByEmail(tempEmail);
			if (adminObjectFromDb != null) {
				throw new Exception("Admin with the same email already exist!");
			}
		}
		adminService.saveAdmin(admin);
		return "Hi" + admin.getAdmin_name() + "You have successfully registered";
	}

	@PostMapping("/login")
	public Admin loginAdmin(@RequestBody Admin admin) throws Exception {
		Admin adminFromDb = null;
		String tempAdminEmail = admin.getAdmin_email();
		String tempAdminPassword = admin.getAdmin_password();
		if (tempAdminEmail != null && tempAdminPassword != null) {
			adminFromDb = adminService.findAdminByEmailAndPassword(tempAdminEmail, tempAdminPassword);
		}
		if(adminFromDb == null) {
			throw new Exception("Bad Credentials");
		}
		return adminFromDb;
	}


	@PostMapping("/foodItems")
	public String addFoodItem(@RequestBody Food foodItem) {
	String response=	restTemplate.postForObject("http://localhost:8003/food/foodItems/", foodItem, String.class);
		return "Hi admin Food Item " + foodItem.getFood_name() + " Has been addded";
	}
	

	@GetMapping("/foodItems")
	public Food[] getAllFoodItems() {
		
		ResponseEntity<Food[]> response=restTemplate.getForEntity("http://localhost:8003/food/foodItems/", Food[].class);
		return response.getBody();
	}

	@DeleteMapping("/foodItems/{id}")
	public String deleteFoodItemById(@PathVariable("id") int id ) {
		Map<String, Integer> params=new HashMap<>();
		params.put("id", id);
		restTemplate.delete("http://localhost:8003/food/foodItems/{id}", params);
		return "Item deleted successfully";
	}
	
	@GetMapping("/foodItems/{category}")
	public Food[] getFoodItemsByCategory(@PathVariable("category") String category) {
		ResponseEntity<Food[]> response=restTemplate.getForEntity("http://localhost:8003/food/foodItems/", Food[].class);
		return response.getBody();
	}
}