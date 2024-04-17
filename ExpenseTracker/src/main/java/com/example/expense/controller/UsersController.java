package com.example.expense.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.expense.entity.Users;
import com.example.expense.services.UsersService;
import com.example.expense.services.UsersServiceImplementation;

import jakarta.servlet.http.HttpSession;

@Controller
public class UsersController {
	@Autowired
	UsersService userv;
	
	@PostMapping("/register")
	public String addUsers(@ModelAttribute Users u) {
		boolean status=userv.emailExists(u.getEmail());
		if(status==false) {
			userv.addUsers(u);
			return "login";
		}else {
			return "register";
		}
		
		
	}
	
	@GetMapping("/login")
	public String validateUsers(@RequestParam String userOrPass, @RequestParam String password,HttpSession session) {
		if(userv.validateUsers(userOrPass, password)) {
			session.setAttribute("userOrPass", userOrPass);
			return "home";
		}
		else {
			return "login";
		}
	}
	 @PostMapping("/logout")
	    public String logout(HttpSession session) {
	        session.invalidate(); // Invalidate the session
	        return "login"; // Redirect to login page
	    }

}
