package com.example.expense.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.expense.entity.Category;
import com.example.expense.entity.Payment;
import com.example.expense.entity.Vendor;
import com.example.expense.services.CategoryService;
import com.example.expense.services.PaymentService;
import com.example.expense.services.VendorService;

@Controller
public class NavController {
	
	@Autowired
	CategoryService cserv;
	
	@Autowired
	VendorService vserv;
	
	@Autowired
	PaymentService pserv;
	
	@GetMapping("/map-register")
	public String register() {
		return "register";
	}
	
	@GetMapping("/map-login")
	public String login() {
		return "login";
	}
   @GetMapping("/map-home")
   public String home() {
	   return "home";
   }
	
	
    @GetMapping("/map-addCategory")
	public String addCategory(Model model) {
    	 List<Category> clist = cserv.viewCat();
         model.addAttribute("clist", clist);
		return "addCategory";
	}
    
   @GetMapping("/map-addVendor")
   public String addVendor() {
	   return "addVendor";
   }
   
   @GetMapping("/map-addPayment")
   public String addPayment() {
	   return "addPayment";
   }
   @GetMapping("/map-addTransaction")
  	public String addTransaction(Model model) {
      	 List<Category> clist = cserv.viewCat();
         model.addAttribute("clist", clist);
         
         List<Vendor> vlist = vserv.viewVen();
         model.addAttribute("vlist", vlist);
         
         List<Payment> plist = pserv.viewPay();
         model.addAttribute("plist", plist);
  		return "addTransaction";
  	}
}
