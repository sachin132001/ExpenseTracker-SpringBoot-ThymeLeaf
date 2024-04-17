package com.example.expense.services;

import java.util.List;

import com.example.expense.entity.Category;

public interface CategoryService {
	public String addCat(Category cat);
	
	public List<Category> viewCat();
	 public Category getCategoryById(int cid);
	 void updateCategory(Category updatedCategory);

	void deleteCategoryById(int id);
	public String getParentCategoryName(int cid);
	
	public void updateCat(Category cat);
}
