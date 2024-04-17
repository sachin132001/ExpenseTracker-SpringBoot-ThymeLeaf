package com.example.expense.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.expense.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
