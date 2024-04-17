package com.example.expense.services;

import java.util.List;

import com.example.expense.entity.Category;
import com.example.expense.entity.Vendor;

public interface VendorService {
	
public String addVen(Vendor ven);
	
	public List<Vendor> viewVen();
	 public Vendor getVendorById(int vid);
	 void updateVendor(Vendor updatedVendor);

	void deleteVendorById(int id);
	
	public void updateVen(Vendor ven);
	

}
