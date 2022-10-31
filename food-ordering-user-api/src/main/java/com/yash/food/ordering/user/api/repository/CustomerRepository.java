package com.yash.food.ordering.user.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yash.food.ordering.user.api.entity.Customer;


@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer>{

	Customer findByCustomerEmailAndCustomerPassword(String tempCustomerEmail, String tempCustomerPassword);
	Customer findByCustomerEmail(String email);
}
