package com.example.expense.entity;

import java.sql.Date;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

public class TransactionDTO {
	
	
     int tid;

     Date tdate;

     int tcat;

     String particulars;

     double amount;

     int tven;

     int tpay;

     String tdetails;

     String remarks;

	public TransactionDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TransactionDTO(int tid, Date tdate, int tcat, String particulars, double amount, int tven, int tpay,
			String tdetails, String remarks) {
		super();
		this.tid = tid;
		this.tdate = tdate;
		this.tcat = tcat;
		this.particulars = particulars;
		this.amount = amount;
		this.tven = tven;
		this.tpay = tpay;
		this.tdetails = tdetails;
		this.remarks = remarks;
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public Date getTdate() {
		return tdate;
	}

	public void setTdate(Date tdate) {
		this.tdate = tdate;
	}

	public int getTcat() {
		return tcat;
	}

	public void setTcat(int tcat) {
		this.tcat = tcat;
	}

	public String getParticulars() {
		return particulars;
	}

	public void setParticulars(String particulars) {
		this.particulars = particulars;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getTven() {
		return tven;
	}

	public void setTven(int tven) {
		this.tven = tven;
	}

	public int getTpay() {
		return tpay;
	}

	public void setTpay(int tpay) {
		this.tpay = tpay;
	}

	public String getTdetails() {
		return tdetails;
	}

	public void setTdetails(String tdetails) {
		this.tdetails = tdetails;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Override
	public String toString() {
		return "TransactionDTO [tid=" + tid + ", tdate=" + tdate + ", tcat=" + tcat + ", particulars=" + particulars
				+ ", amount=" + amount + ", tven=" + tven + ", tpay=" + tpay + ", tdetails=" + tdetails + ", remarks="
				+ remarks + "]";
	}

    
}
