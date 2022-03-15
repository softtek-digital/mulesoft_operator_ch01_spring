package com.softtek.first_api.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.softtek.first_api.entity.Customer;
import com.softtek.first_api.service.CustomerService;

@RestController
@RequestMapping(value = "/api/v1/customer", produces = "application/json")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping
	public ResponseEntity<Customer> add(@RequestBody Customer customer) {
		Customer c = customerService.add(customer);
		return ResponseEntity.ok(c);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getById(@PathVariable Long id) {
		Optional<Customer> oCustomer = customerService.getById(id);
		if (oCustomer.isPresent()) {
			return ResponseEntity.ok(oCustomer.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable Long id) {
		customerService.deleteById(id);
	}
}
