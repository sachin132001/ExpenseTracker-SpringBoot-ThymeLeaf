package com.example.expense.services;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import com.example.expense.entity.Payment;
import com.example.expense.entity.Transaction;

public interface TransactionService {
	public String addTrans(Transaction trans);
	public List<Transaction> viewTrans();
	 public Transaction getTransactionById(int tid);
	 void updateTransaction(Transaction updatedTransaction);

	void deleteTransactionById(int id);
	public String getCategoryName(int tid);
	public String getVendorName(int tid);
	public String getPaymentType(int tid);
	

	public List<Object[]> getTransactionReport(LocalDate fromDate, LocalDate toDate);

}
