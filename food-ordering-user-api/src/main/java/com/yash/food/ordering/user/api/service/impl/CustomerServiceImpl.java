package com.yash.food.ordering.user.api.service.impl;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.food.ordering.user.api.entity.Customer;
import com.yash.food.ordering.user.api.repository.CustomerRepository;

/**
 * 
 * the class CustomerServiceImpl
 *
 */
@Service
public class CustomerServiceImpl implements CustomerService {

	private static final Logger logger = LogManager.getLogger(CustomerServiceImpl.class);
	
	/** the customerRepository */
	@Autowired
	private CustomerRepository customerRepository;

	/**
	 * the registerCustomer()
	 */
	@Override
	public void registerCustomer(Customer customer) {
		try {
			customerRepository.save(customer);
		} catch (Exception exception) {
			logger.info("registerCustomer() :: " + exception.getMessage());
		}
	}

	/**
	 * the getCustomerById()
	 * 
	 * @param id
	 * @return Optional<Customer>
	 */
	@Override
	public Optional<Customer> getCustomerById(int id) {
		Optional<Customer> customer = null;
		try {
			customer = Optional.of(customerRepository.findById(id).get());
			if (customer.isPresent()) {
				return customer;
			} else {
				throw new Exception("No Customer Is exist with the " + id);
			}
		} catch (Exception exception) {

			logger.info("getCustomerById() :: " + exception.getMessage());
			System.out.println("exception");
		}
		return customer;
	}

	/**
	 * the getCustomerByEmail()
	 * 
	 * @param email
	 * @return Optional<Customer>
	 * 
	 */
	@Override
	public Optional<Customer> getCustomerByEmail(String email) {

		Optional<Customer> customer = null;

		try {
			customer = Optional.of(customerRepository.findByCustomerEmail(email));
		} catch (Exception exception) {
			logger.info("getCustomerByEmail() :: " + exception.getMessage());
		}

		return customer;
	}

	/**
	 * the findCustomerByEmailAndPassword()
	 * 
	 * @param tempCustomerEmail,tempCustomerPassword
	 * @return Optional<Customer>
	 */
	@Override
	public Optional<Customer> findCustomerByEmailAndPassword(String tempCustomerEmail, String tempCustomerPassword) {

		Optional<Customer> customer = null;
		try {
			customer = Optional.of(
					customerRepository.findByCustomerEmailAndCustomerPassword(tempCustomerEmail, tempCustomerPassword));
		} catch (Exception exception) {
			logger.info("findCustomerByEmailAndPassword() :: " + exception.getMessage());
		}

		return customer;
	}

}
