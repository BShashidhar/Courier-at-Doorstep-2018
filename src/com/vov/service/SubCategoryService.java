package com.vov.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vov.dao.SubCategoryDaoIF;
import com.vov.pojos.SubCategory;

@Service
@Transactional
public class SubCategoryService implements SubCategoryServiceIF{

	@Autowired
	private SubCategoryDaoIF subdao;
	
	@Override
	public SubCategory saveSubCatgory(SubCategory sub) {
		if (subdao.saveSubCatgory(sub) != null) {
			return sub;
		}
		return null;
	}

	@Override
	@Transactional(readOnly=true)
	public List<SubCategory> getSubCategoriesByCategoryId(int cid) {
		List<SubCategory> list = null;
		list = subdao.getSubCategoriesByCategoryId(cid);
		if (list != null) {
			return list;
		}
		return null;
	}

	@Override
	public SubCategory updateSubCategory(SubCategory sub) {
		if (subdao.updateSubCategory(sub) != null) {
			return sub;
		}
		return null;
	}

	@Override
	@Transactional(readOnly=true)
	public SubCategory getSubCategory(int scid) {
		return subdao.getSubCategory(scid);
	}
	
	@Override
	public int  deleteSubCategory(int id) {
		subdao.deleteSubCategory(id);
		return id;
	}
}
