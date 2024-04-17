package com.example.expense.services;

import com.example.expense.entity.Users;

public interface UsersService {
	public String addUsers(Users user);
	
	public boolean emailExists(String email);
	
	public boolean validateUsers(String userOrPass,String password);

}
