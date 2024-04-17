package com.example.expense.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.expense.entity.Vendor;

public interface VendorRepository extends JpaRepository<Vendor, Integer>{

}
