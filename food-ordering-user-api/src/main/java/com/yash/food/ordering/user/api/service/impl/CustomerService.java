package com.yash.food.ordering.user.api.service.impl;

import java.util.List;
import java.util.Optional;

import com.yash.food.ordering.user.api.entity.Customer;



/**
 * 
 * the CustomerService
 *
 */
public interface CustomerService {

	public void registerCustomer(Customer customer);

	public Optional<Customer> findCustomerByEmailAndPassword(String tempCustomerEmail, String tempCustomerPassword);

	public Optional<Customer> getCustomerById(int id);

	public Optional<Customer> getCustomerByEmail(String email);
		
}
