package com.example.expense.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.example.expense.entity.Category;
import com.example.expense.services.CategoryService;

@Controller
public class CategoryController {
	@Autowired
	CategoryService cserv;
	@PostMapping("/addCat")
	public String addCat(@ModelAttribute Category cat) {
		cserv.addCat(cat);
		return "redirect:/map-view";
	}
	 
    @GetMapping("/map-view")
    public String viewCat(Model model) {
        List<Category> clist = cserv.viewCat();
        model.addAttribute("clist", clist);
        return "category"; // Assuming "category.html" is your view template
    }
    


    @GetMapping("/update/{id}") // Corrected path variable
    public String showUpdateCategoryForm(@PathVariable("id") int id, Model model) {
    	 List<Category> clist = cserv.viewCat();
         model.addAttribute("clist", clist);
        Category category = cserv.getCategoryById(id);
        String parentCategoryName = cserv.getParentCategoryName(id);
        model.addAttribute("category", category);
        model.addAttribute("parentCategoryName", parentCategoryName);
        return "updateCategory"; // Assuming you have a corresponding HTML file for updating category
    }

    @PostMapping("/update/{id}") // Changed to PostMapping
    public String updateCategory(@PathVariable("id") int id, @ModelAttribute("category") Category category) {
        category.setCid(id); // Set the id explicitly
        cserv.updateCategory(category);
        return "redirect:/map-view"; // Redirect to the view category page
    }
    

    @PostMapping("/delete/{id}")
    public String deleteCategory(@PathVariable("id") int id) {
        cserv.deleteCategoryById(id);
        return "redirect:/map-view"; // Redirect to the view category page
    }


}
