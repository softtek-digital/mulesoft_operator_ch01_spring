package com.softtek.first_api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.softtek.first_api.entity.Customer;
import com.softtek.first_api.repository.CustomerRepository;

@Component
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	public Customer add(Customer customer) {
		// business rules
		// orchestation
		return customerRepository.save(customer);
	}
	
	public Optional<Customer> getById(Long id) {
		return customerRepository.findById(id);
	}
	
	public void deleteById(Long id) {
		customerRepository.deleteById(id);
	}
}
