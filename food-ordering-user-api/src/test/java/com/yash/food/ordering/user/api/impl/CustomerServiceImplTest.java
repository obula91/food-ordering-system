package com.yash.food.ordering.user.api.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.yash.food.ordering.user.api.entity.Customer;
import com.yash.food.ordering.user.api.repository.CustomerRepository;
import com.yash.food.ordering.user.api.service.impl.CustomerService;
import com.yash.food.ordering.user.api.service.impl.CustomerServiceImpl;

@SpringBootTest
public class CustomerServiceImplTest {

	@Mock
	private CustomerRepository customerRepository;
	
	@InjectMocks
	CustomerServiceImpl customerServiceImpl;
	
	private String name="";
	
	Optional<Customer> customer=Optional.of(new Customer(1, name, name, name, name));
	
	@Test
	public void testGetCustomerById() {
		Mockito.when(customerRepository.findById(1)).thenReturn(customer);
		Optional<Customer> customer= customerServiceImpl.getCustomerById(1);
		assertEquals(name, customer.get().getCustomer_name());
	}
	
	@Test
	public void testGetCustomerByEmail() {
		Mockito.when(customerRepository.findByCustomerEmail(name)).thenReturn(new Customer(1, name, name, name, name));
		Optional<Customer> customer=customerServiceImpl.getCustomerByEmail(name);
		assertEquals(name, customer.get().getCustomer_name());
	}
	
	@Test
	public void testFindCustomerByEmailAndPassword() {
		Mockito.when(customerRepository.findByCustomerEmailAndCustomerPassword(name, name)).thenReturn(new Customer(1, name, name, name, name));
		Optional<Customer> customer=customerServiceImpl.findCustomerByEmailAndPassword(name, name);
		assertEquals(name, customer.get().getCustomer_name());
	}
	
	
}
