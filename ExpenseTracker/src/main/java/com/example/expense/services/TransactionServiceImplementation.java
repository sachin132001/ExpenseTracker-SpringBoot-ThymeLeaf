package com.example.expense.services;

import java.time.LocalDate;
import java.util.*;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.expense.entity.Category;
import com.example.expense.entity.Payment;
import com.example.expense.entity.Transaction;
import com.example.expense.repositories.TransactionRepository;

@Service
public class TransactionServiceImplementation implements TransactionService {
	@Autowired
	TransactionRepository trepo;

	@Override
	public String addTrans(Transaction trans) {
		// TODO Auto-generated method stub
		trepo.save(trans);
		return null;
	}

	@Override
	public List<Transaction> viewTrans() {
		List<Transaction> tlist=trepo.findAll();
		return tlist;
	}

	@Override
	public Transaction getTransactionById(int tid) {
		return trepo.findById(tid).orElse(null);
	}

	@Override
	public void updateTransaction(Transaction updatedTransaction) {
		// TODO Auto-generated method stub
		 trepo.save(updatedTransaction);
		
	}

	@Override
	public void deleteTransactionById(int id) {
		// TODO Auto-generated method stub
		trepo.deleteById(id);
		
	}

	@Override
	public String getCategoryName(int tid) {
		Transaction transaction = trepo.findById(tid).orElse(null);
        if (transaction != null) {
            // Assuming p_cat holds the name of the parent category
            return transaction.getTcat();
        }
        return null;
	}

	@Override
	public String getVendorName(int tid) {
		Transaction transaction = trepo.findById(tid).orElse(null);
        if (transaction != null) {
            // Assuming p_cat holds the name of the parent category
            return transaction.getTven();
        }
        return null;
	}

	@Override
	public String getPaymentType(int tid) {
		Transaction transaction = trepo.findById(tid).orElse(null);
        if (transaction != null) {
            // Assuming p_cat holds the name of the parent category
            return transaction.getTpay();
        }
        return null;
	}

	  @Override
	    public List<Object[]> getTransactionReport(LocalDate fromDate, LocalDate toDate) {
	        return trepo.getTransactionReport(fromDate, toDate);
	    }

   
	
	}


