package com.example.expense.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.expense.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {

}
