package com.example.expense.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.expense.entity.Users;

public interface UsersRepository extends JpaRepository<Users, Integer>{
	public Users findByEmail(String email);
	public Users findByName(String name);

}
