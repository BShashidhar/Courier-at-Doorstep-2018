package com.vov.dao;

import java.util.List;

import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vov.pojos.Category;

@Repository
public class CategoryDao implements CategoryDaoIF{
	@Autowired
	private SessionFactory sf;
	
	@Override
	public Category saveCatgory(Category c)
	{
		if((Integer)sf.getCurrentSession().save(c) != null) 
		{
			return c;
		}
		return null;
	}
	
	@Override
	public Category getCategoryById(int id) 
	{
		Session hs = sf.getCurrentSession();
		return  (Category)hs.createQuery("Select c from Category c where c.cid=:cid",Category.class)
				.setParameter("cid", id).getSingleResult();
	}

	@Override
	public List<Category> getCategories() 
	{
		return sf.getCurrentSession().createQuery("Select c from Category c",Category.class).getResultList();
	}
	
	@Override
	public Category updateCategory(Category c) 
	{
		Category cat = getCategoryById(c.getCid());
		cat.setName(c.getName());
		cat.setDescription(c.getDescription());
		cat.setImage(c.getImage());
		return cat;
	}
	
	@Override
	public Category deleteCategory(int id) 
	{
		Category cat = getCategoryById(id);
		//sf.getCurrentSession().delete(cat);
		return cat;
	}
}
