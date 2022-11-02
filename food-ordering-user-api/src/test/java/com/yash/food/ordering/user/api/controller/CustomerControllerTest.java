package com.yash.food.ordering.user.api.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import com.yash.food.ordering.user.api.entity.Customer;
import com.yash.food.ordering.user.api.model.Food;
import com.yash.food.ordering.user.api.service.controller.CustomerController;
import com.yash.food.ordering.user.api.service.impl.CustomerService;
import static pl.pojo.tester.api.assertion.Assertions.assertPojoMethodsForAll;
import pl.pojo.tester.api.assertion.Method;

@SpringBootTest
public class CustomerControllerTest {

	@Mock
	CustomerService customerService;
	
	@InjectMocks
	CustomerController customerController;
	
	private String name="test";
	
	Optional<Customer> customer=Optional.of(new Customer(1, name, name, name, name));
	
	
	
	
	@Test
	public void testRegisterCustomer() {
	Mockito.when(customerService.getCustomerByEmail(name)).thenReturn(customer);
	
	 Optional<Customer> customer=  customerController.getCustomerByEmail(name);
	 
	Assertions.assertEquals(name, customer.get().getCustomer_name());
	
	}
	
	@Test
	public void testGetCustomerById() {
		Mockito.when(customerService.getCustomerById(1)).thenReturn(customer);
		
		 Optional<Customer> customer=  customerController.getCustomerById(1);
		 
		Assertions.assertEquals(name, customer.get().getCustomer_name());
	}
	
	@Test
	public void testLoginCustomer() throws Exception {
		Mockito.when(customerService.findCustomerByEmailAndPassword(name, name)).thenReturn(customer);
		
		 Optional<Customer> customer=  customerController.loginCustomer(new Customer(1, name, name, name, name));
		 
		Assertions.assertEquals(name, customer.get().getCustomer_name());
	}
	

}
