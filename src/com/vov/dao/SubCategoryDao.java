package com.vov.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vov.pojos.SubCategory;

@Repository
public class SubCategoryDao implements SubCategoryDaoIF{

	@Autowired
	private SessionFactory sf;
	
	@Override
	public SubCategory saveSubCatgory(SubCategory sub) {
		if((Integer)sf.getCurrentSession().save(sub) != null) {
			return sub;
		}
		return null;
	}
	
	@Override
	public List<SubCategory> getSubCategoriesByCategoryId(int cid) {
		return sf.getCurrentSession().createQuery("Select sub from SubCategory sub JOIN FETCH sub.category where sub.category.cid=:cid",
				SubCategory.class)
				.setParameter("cid", cid)
				.getResultList();
	}
	
	@Override
	public SubCategory updateSubCategory(SubCategory sub) {
		SubCategory sub2 = getSubCategory(sub.getScid());
		sub2.setName(sub.getName());
		sub2.setImage(sub.getImage());
		sub2.setDescription(sub.getDescription());
		return sub2;
	}

	@Override
	public SubCategory getSubCategory(Integer id) {	
		return sf.getCurrentSession().get(SubCategory.class, id);
	}
	
	@Override
	public int  deleteSubCategory(int id) {
		SubCategory subcat = getSubCategory(id);
		subcat.setCategory(null);
		sf.getCurrentSession().delete(subcat);
		return id;
	}
}