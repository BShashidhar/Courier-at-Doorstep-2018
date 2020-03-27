package com.vov.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vov.dao.CategoryDaoIF;
import com.vov.pojos.Category;

@Service
@Transactional
public class CategoryService implements CategoryServiceIF {
	
	@Autowired
	private CategoryDaoIF catdao;
	
	@Override
	public Category saveCatgory(Category c) {
		if (catdao.saveCatgory(c) != null) {
			return c;
		}
		return null;
	}

	@Override
	@Transactional(readOnly=true)
	public Category getCategoryById(int id) {
		Category c = null;
		c = catdao.getCategoryById(id);
		if (c != null) {
			return c;
		}
		return null;
	}

	@Override
	@Transactional(readOnly=true)
	public List<Category> getCategories() {
		List<Category> list = null;
		list = catdao.getCategories();
		if (list != null) {
			return list;
		}
		return null;
	}
	
	@Override
	public Category deleteCategory(int id) {
		return catdao.deleteCategory(id);
	}
	@Override
	public Category updateCategory(Category c) {
		return catdao.updateCategory(c);
	}
}
