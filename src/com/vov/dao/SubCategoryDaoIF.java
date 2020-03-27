package com.vov.dao;

import java.util.List;

import com.vov.pojos.SubCategory;

public interface SubCategoryDaoIF {
	public SubCategory saveSubCatgory(SubCategory sub);
	public List<SubCategory> getSubCategoriesByCategoryId(int cid);
	public SubCategory updateSubCategory(SubCategory sub);
	public SubCategory getSubCategory(Integer id);
	public int deleteSubCategory(int id);
}
