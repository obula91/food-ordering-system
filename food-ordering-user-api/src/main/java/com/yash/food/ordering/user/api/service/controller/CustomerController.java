package com.yash.food.ordering.user.api.service.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.yash.food.ordering.user.api.entity.Customer;
import com.yash.food.ordering.user.api.model.Food;
import com.yash.food.ordering.user.api.service.impl.CustomerService;

/**
 *
 * class CustomerController
 * 
 */

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired(required = true)
	private RestTemplate restTemplate;
	/**
	 * the  customerService
	 */
	@Autowired
	private CustomerService customerService;
	
	/**
	 * the registerCustomer()
	 * @param customer
	 * @return String
	 */
	@PostMapping("/register")
	public String registerCustomer(@RequestBody Customer customer) {
		customerService.registerCustomer(customer);
		return "Hey " + customer.getCustomer_name() + "You have successfully registered";
	}
	
	/**
	 * the loginCustomer
	 * @param customer
	 * @return Optional<Customer>
	 * @throws Exception
	 */
	@PostMapping("/login")
	public Optional<Customer> loginCustomer(@RequestBody Customer customer) throws Exception {
		Optional<Customer> customerFromDb = null;
		String tempCustomerEmail = customer.getCustomer_email();
		String tempCustomerPassword = customer.getCustomer_password();
		if(tempCustomerEmail!= null && tempCustomerPassword !=null) {
			customerFromDb = customerService.findCustomerByEmailAndPassword(tempCustomerEmail,tempCustomerPassword);
		}
		if(customerFromDb == null) {
			throw new Exception("Bad Credentials");
		}
		return customerFromDb;
	}
	
	/**
	 * the getCustomerById()
	 * @param id
	 * @return Optional<Customer>
	 */
	@GetMapping("/{id}")
	public Optional<Customer> getCustomerById(@PathVariable("id") int id) {
	
		return customerService.getCustomerById(id);
	}
	
	/**
	 * the getCustomerByEmail()
	 * @param email
	 * @return Optional<Customer>
	 */
	@GetMapping("/profile/{email}")
	public Optional<Customer> getCustomerByEmail(@PathVariable("email") String email) {
		return customerService.getCustomerByEmail(email);
	}
	
	
	

	@GetMapping("/foodItems")
	public Food[] getAllFoodItems() {
		
		ResponseEntity<Food[]> response=restTemplate.getForEntity("http://localhost:8003/food/foodItems/", Food[].class);
		return response.getBody();
	}
	
	
}
