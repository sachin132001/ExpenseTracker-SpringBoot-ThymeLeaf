package com.example.expense.entity;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreRemove;
import jakarta.persistence.PreUpdate;

@Entity
public class Transaction {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     int tid;

     Date tdate;

     String tcat;

     String particulars;

     double amount;

     String tven;

     String tpay;

     String tdetails;

     String remarks;

    
    
    // Relationships
    
    // Many transactions can belong to one category
     @ManyToOne
     @JoinColumn(name = "category_cid")
     Category category;
    
    // Many transactions can have one vendor
     @ManyToOne
   
     Vendor vendor;
    
    // Many transactions can have one payment type
     @ManyToOne
    
     Payment payment;
     @PreRemove
     private void preRemove() {
         // Remove the association with category, vendor, and payment
         this.category.getTransactions().remove(this);
         this.vendor.getTransactions().remove(this);
         this.payment.getTransactions().remove(this);
         
         // Set the associations to null to prevent cascade deletion
         this.category = null;
         this.vendor = null;
         this.payment = null;
     }

	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Transaction(int tid, Date tdate, String tcat, String particulars, double amount, String tven, String tpay,
			String tdetails, String remarks,  Category category, Vendor vendor,
			Payment payment) {
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
		this.category = category;
		this.vendor = vendor;
		this.payment = payment;
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

	public String getTcat() {
		return tcat;
	}

	public void setTcat(String tcat) {
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

	public String getTven() {
		return tven;
	}

	public void setTven(String tven) {
		this.tven = tven;
	}

	public String getTpay() {
		return tpay;
	}

	public void setTpay(String tpay) {
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

	

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Vendor getVendor() {
		return vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	@Override
	public String toString() {
		return "Transaction [tid=" + tid + ", tdate=" + tdate + ", tcat=" + tcat + ", particulars=" + particulars
				+ ", amount=" + amount + ", tven=" + tven + ", tpay=" + tpay + ", tdetails=" + tdetails + ", remarks="
				+ remarks + ", category=" + category + ", vendor=" + vendor
				+ ", payment=" + payment + "]";
	}
    
    // Constructors, getters, and setters
    // Constructor
	
   
}

