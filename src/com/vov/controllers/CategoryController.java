package com.vov.controllers;

import java.util.List;

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

import com.vov.pojos.Category;
import com.vov.service.CategoryServiceIF;

@RestController
@RequestMapping("/category")
@CrossOrigin(origins="http://localhost:4200",allowedHeaders="*")
public class CategoryController {
	
	@Autowired
	private CategoryServiceIF catservice;
	
	@GetMapping(value="/get/{id}")
	public Category getCategoryById(@PathVariable int id) {
		try 
		{
			return catservice.getCategoryById(id);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			return null;
		}
	}
	
	@PostMapping(value="/save")
	public ResponseEntity<?> saveCategory(@RequestBody Category c)
	{
		try
		{
			return new ResponseEntity<Category>(catservice.saveCatgory(c),HttpStatus.OK);
		}
		catch (Exception e) 
		{
			return new ResponseEntity<String>("Unable to save Category",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value="/list")
	public List<Category> getCategories() 
	{
		try
		{
			return catservice.getCategories();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			return null;
		}
	}
	
	
	@PutMapping(value="/update")
	public ResponseEntity<?> updateCategory(@RequestBody Category c)
	{
		try
		{
			return new ResponseEntity<Category>(catservice.updateCategory(c),HttpStatus.OK);
		}
		catch (Exception e) 
		{
			return new ResponseEntity<String>("Unable to update Category",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping(value="/delete/{id}")
	public Category deleteCategory(@PathVariable int id) 
	{
		try
		{
			return catservice.deleteCategory(id);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			return null;
		}
	}
}
