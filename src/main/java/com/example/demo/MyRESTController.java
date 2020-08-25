package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController
public class MyRESTController {

	@Autowired
	ContactRepository repository;

	
	

	
	@GetMapping("/contacts")
	public Iterable<Contact> getContacts() {
		return repository.findAll();
	}
	
	
	 @PostMapping("/addContacts")
	 String newContact(@RequestBody Contact newContact) {
	     repository.save(newContact);
	     return "created";
	  }
	
		
   @DeleteMapping("/contacts/{email}")
		  String deleteEmployee(@PathVariable String email) {
			  repository.deleteByEmail(email);
			  return "deleted";
	}
   
   @GetMapping("/viewContacts")
   public ModelAndView allContacts() {
       List<Contact> list = repository.findAll();
       ModelAndView map = new ModelAndView("contact");
       map.addObject("contact", list);
       return map;
   }
   
   
		 
	

}

