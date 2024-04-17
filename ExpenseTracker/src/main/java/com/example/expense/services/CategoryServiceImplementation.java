package com.example.expense.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.expense.entity.Category;
import com.example.expense.repositories.CategoryRepository;

@Service
public class CategoryServiceImplementation implements CategoryService{
	@Autowired
	CategoryRepository crepo;

	@Override
	public String addCat(Category cat) {
		// TODO Auto-generated method stub
		crepo.save(cat);
		return null;
	}

	@Override
	public List<Category> viewCat() {
		// TODO Auto-generated method stub
		List<Category> clist=crepo.findAll();
		return clist;
	}
	 @Override
	    public Category getCategoryById(int cid) {
	        return crepo.findById(cid).orElse(null);
	    }

	    @Override
	    public void updateCategory(Category updatedCategory) {
	        crepo.save(updatedCategory);
	    }

		@Override
		public void deleteCategoryById(int id) {
			// TODO Auto-generated method stub
			crepo.deleteById(id);
			
		}

		@Override
		public String getParentCategoryName(int cid) {
			Category category = crepo.findById(cid).orElse(null);
	        if (category != null) {
	            // Assuming p_cat holds the name of the parent category
	            return category.getP_cat();
	        }
	        return null;
		}

		@Override
		public void updateCat(Category cat) {
			// TODO Auto-generated method stub
			crepo.save(cat);			
		}
	   
}
