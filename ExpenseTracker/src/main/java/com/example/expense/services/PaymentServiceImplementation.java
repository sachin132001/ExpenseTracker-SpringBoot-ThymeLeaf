package com.example.expense.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.expense.entity.Category;
import com.example.expense.entity.Payment;
import com.example.expense.entity.Vendor;
import com.example.expense.repositories.PaymentRepository;

@Service
public class PaymentServiceImplementation implements PaymentService{
	@Autowired
	PaymentRepository prepo;

	@Override
	public String addPay(Payment pay) {
		// TODO Auto-generated method stub
		prepo.save(pay);
		return null;
	}

	@Override
	public List<Payment> viewPay() {
		List<Payment> plist=prepo.findAll();
		return plist;
	}

	@Override
	public Payment getPaymentById(int pid) {
		 return prepo.findById(pid).orElse(null);
	}

	@Override
	public void updatePayment(Payment updatedPayment) {
		// TODO Auto-generated method stub
		 prepo.save(updatedPayment);
		
	}

	@Override
	public void deletePaymentById(int id) {
		// TODO Auto-generated method stub
		prepo.deleteById(id);
		
	}
	
	@Override
	public void updatePay(Payment pay) {
		// TODO Auto-generated method stub
		prepo.save(pay);			
	}

}
