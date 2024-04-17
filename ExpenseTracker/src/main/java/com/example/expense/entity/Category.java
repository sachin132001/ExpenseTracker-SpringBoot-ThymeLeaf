package com.example.expense.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Category {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int cid;
	String cat_name;
	String cat_desc;
	String cat_type;
	String p_cat;
	@OneToMany
	 List<Transaction> transactions;
	 
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Category(int cid, String cat_name, String cat_desc, String cat_type, String p_cat,
			List<Transaction> transactions) {
		super();
		this.cid = cid;
		this.cat_name = cat_name;
		this.cat_desc = cat_desc;
		this.cat_type = cat_type;
		this.p_cat = p_cat;
		this.transactions = transactions;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCat_name() {
		return cat_name;
	}

	public void setCat_name(String cat_name) {
		this.cat_name = cat_name;
	}

	public String getCat_desc() {
		return cat_desc;
	}

	public void setCat_desc(String cat_desc) {
		this.cat_desc = cat_desc;
	}

	public String getCat_type() {
		return cat_type;
	}

	public void setCat_type(String cat_type) {
		this.cat_type = cat_type;
	}

	public String getP_cat() {
		return p_cat;
	}

	public void setP_cat(String p_cat) {
		this.p_cat = p_cat;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	@Override
	public String toString() {
		return "Category [cid=" + cid + ", cat_name=" + cat_name + ", cat_desc=" + cat_desc + ", cat_type=" + cat_type
				+ ", p_cat=" + p_cat + ", transactions=" + transactions + "]";
	}
	

}
