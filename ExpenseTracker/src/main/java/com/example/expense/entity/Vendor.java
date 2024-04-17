package com.example.expense.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Entity
public class Vendor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int vid;
    String vname;
    String vloc;
    @OneToMany
    List<Transaction> transactions;
    
	public Vendor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Vendor(int vid, String vname, String vloc, List<Transaction> transactions) {
		super();
		this.vid = vid;
		this.vname = vname;
		this.vloc = vloc;
		this.transactions = transactions;
	}

	public int getVid() {
		return vid;
	}

	public void setVid(int vid) {
		this.vid = vid;
	}

	public String getVname() {
		return vname;
	}

	public void setVname(String vname) {
		this.vname = vname;
	}

	public String getVloc() {
		return vloc;
	}

	public void setVloc(String vloc) {
		this.vloc = vloc;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	@Override
	public String toString() {
		return "Vendor [vid=" + vid + ", vname=" + vname + ", vloc=" + vloc + ", transactions=" + transactions + "]";
	}
	
	

   

}
