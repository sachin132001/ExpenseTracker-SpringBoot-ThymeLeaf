package com.example.expense.services;

import java.util.List;

import com.example.expense.entity.Payment;


public interface PaymentService {
public String addPay(Payment pay);
	
	public List<Payment> viewPay();
	 public Payment getPaymentById(int pid);
	 void updatePayment(Payment updatedPayment);

	void deletePaymentById(int id);
	public void updatePay(Payment pay);
	


}
