package com.vov.dao;

import java.util.List;

import com.vov.pojos.Category;

public interface CategoryDaoIF {
	public Category saveCatgory(Category c);
	public Category getCategoryById(int id);
	public List<Category> getCategories();
	public Category updateCategory(Category c);
	public Category deleteCategory(int id);
}
