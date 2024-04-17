package com.example.expense.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.expense.entity.Users;
import com.example.expense.repositories.UsersRepository;

@Service
public class UsersServiceImplementation implements UsersService {
	@Autowired
	UsersRepository urepo;

	@Override
	public String addUsers(Users user) {
		// TODO Auto-generated method stub
		urepo.save(user);
		
		return "user created";
	}

	@Override
	public boolean emailExists(String email) {
		// TODO Auto-generated method stub
		Users user=urepo.findByEmail(email);
		if(user==null) {
			return false;
		}
		return true;
	}

	@Override
	public boolean validateUsers(String userOrPass, String password) {
		// TODO Auto-generated method stub
		Users user=urepo.findByEmail(userOrPass);
		if(user==null) {
			user=urepo.findByName(userOrPass);
		}
		if(user!=null) {
			String dbpassword=user.getPassword();
			return dbpassword.equals(password);
		}
		return false;
	}

}
