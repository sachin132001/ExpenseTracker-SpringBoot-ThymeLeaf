package com.example.expense.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.expense.entity.Category;
import com.example.expense.entity.Vendor;
import com.example.expense.repositories.VendorRepository;
@Service
public class VendorServiceImplementation implements VendorService{
	@Autowired
	VendorRepository vrepo;
	
	@Override
	public String addVen(Vendor ven) {
		// TODO Auto-generated method stub
		vrepo.save(ven);
		return null;
	}

	

	@Override
	public List<Vendor> viewVen() {
		List<Vendor> vlist=vrepo.findAll();
		return vlist;
	}

	@Override
	public Vendor getVendorById(int vid) {
		 return vrepo.findById(vid).orElse(null);
	}

	@Override
	public void updateVendor(Vendor updatedVendor) {
		// TODO Auto-generated method stub
		 vrepo.save(updatedVendor);
		
	}

	@Override
	public void deleteVendorById(int id) {
		// TODO Auto-generated method stub
		vrepo.deleteById(id);
		
	}
	@Override
	public void updateVen(Vendor ven) {
		// TODO Auto-generated method stub
		vrepo.save(ven);			
	}

	

}
