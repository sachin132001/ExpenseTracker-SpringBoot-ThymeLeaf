package com.example.expense.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Payment {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int pid;
	String ptype;
	String pmode;
	String pdesc;
	
	 @OneToMany
	 private List<Transaction> transactions;
	 
	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Payment(int pid, String ptype, String pmode, String pdesc, List<Transaction> transactions) {
		super();
		this.pid = pid;
		this.ptype = ptype;
		this.pmode = pmode;
		this.pdesc = pdesc;
		this.transactions = transactions;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPtype() {
		return ptype;
	}

	public void setPtype(String ptype) {
		this.ptype = ptype;
	}

	public String getPmode() {
		return pmode;
	}

	public void setPmode(String pmode) {
		this.pmode = pmode;
	}

	public String getPdesc() {
		return pdesc;
	}

	public void setPdesc(String pdesc) {
		this.pdesc = pdesc;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	@Override
	public String toString() {
		return "Payment [pid=" + pid + ", ptype=" + ptype + ", pmode=" + pmode + ", pdesc=" + pdesc + ", transactions="
				+ transactions + "]";
	}
	
	
	

}
