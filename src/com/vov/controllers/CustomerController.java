package com.vov.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vov.pojos.Customer;
import com.vov.service.CustomerServiceIF;

@RestController
@RequestMapping("/customer")
@CrossOrigin(origins="http://localhost:4200",allowedHeaders="*")
public class CustomerController {
	
	@Autowired
	private CustomerServiceIF cservice;
	public CustomerController() 
	{
	}
	
	@GetMapping(value="/get/{id}")
	public Customer getCustomer(@PathVariable int id) 
	{
		try 
		{
			return cservice.getCustomer(id);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			return null;
		}
	}
	
	@PostMapping("/save")
	public ResponseEntity<?> saveCustomer(@RequestBody Customer c) 
	{
		try
		{
			if(cservice.saveCustomer(c) != null) 
			{
				return new ResponseEntity<Customer>(c,HttpStatus.OK);
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return new ResponseEntity<String>("Customer cann't be saved",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	@PutMapping(value = "/update")
	public ResponseEntity<?> updateCustomer(@RequestBody Customer c) 
	{
		try 
		{
				return new ResponseEntity<Customer>(cservice.updateCustomer(c), HttpStatus.OK);
		}
		catch (Exception e)
		{
			return new ResponseEntity<String>("Internal Server Error ", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@DeleteMapping(value="/delete/{id}")
	public Customer deleteCustomer(@PathVariable int id) 
	{
		try
		{
			return cservice.deleteCustomer(id);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			return null;
		}
	}
	
	
}