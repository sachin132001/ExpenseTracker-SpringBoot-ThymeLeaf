package com.example.expense.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.expense.entity.Vendor;
import com.example.expense.services.VendorService;

@Controller
public class VendorController {
	@Autowired
	VendorService vserv;
	
	@PostMapping("/addVen")
	public String addVen(@ModelAttribute Vendor ven) {
		vserv.addVen(ven);
		return "redirect:/map-Vview";
	}
	 
    @GetMapping("/map-Vview")
    public String viewVen(Model model) {
        List<Vendor> vlist = vserv.viewVen();
        model.addAttribute("vlist", vlist);
        return "vendor"; // Assuming "category.html" is your view template
    }
    


    @GetMapping("/Vupdate/{id}") // Corrected path variable
    public String showUpdateVendorForm(@PathVariable("id") int id, Model model) {
        Vendor vendor = vserv.getVendorById(id);
        model.addAttribute("vendor", vendor);
        return "updateVendor"; // Assuming you have a corresponding HTML file for updating category
    }

    @PostMapping("/Vupdate/{id}") // Changed to PostMapping
    public String updateVendor(@PathVariable("id") int id, @ModelAttribute("vendor") Vendor vendor) {
        vendor.setVid(id); // Set the id explicitly
        vserv.updateVendor(vendor);
        return "redirect:/map-Vview"; // Redirect to the view category page
    }
    

    @PostMapping("/Vdelete/{id}")
    public String deleteVendor(@PathVariable("id") int id) {
        vserv.deleteVendorById(id);
        return "redirect:/map-Vview"; // Redirect to the view category page
    }



}
