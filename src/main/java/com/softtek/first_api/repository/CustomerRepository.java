package com.softtek.first_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.softtek.first_api.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
