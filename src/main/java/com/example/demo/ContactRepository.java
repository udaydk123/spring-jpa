package com.example.demo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ContactRepository extends CrudRepository<Contact, Integer> {
	
	String deleteByEmail(String email);
	
	List<Contact> findAll();
	

}
