package com.vov.service;

import java.util.List;

import com.vov.pojos.SubCategory;

public interface SubCategoryServiceIF {
	public SubCategory saveSubCatgory(SubCategory sub);
	public List<SubCategory> getSubCategoriesByCategoryId(int cid);
	public SubCategory updateSubCategory(SubCategory sub);
	public SubCategory getSubCategory(int scid);
	public int deleteSubCategory(int id);
}
