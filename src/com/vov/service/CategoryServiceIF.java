package com.vov.service;

import java.util.List;

import com.vov.pojos.Category;

public interface CategoryServiceIF {
	public Category saveCatgory(Category c);
	public Category getCategoryById(int id);
	public List<Category> getCategories();
	public Category updateCategory(Category c);
	public Category deleteCategory(int id);
}
