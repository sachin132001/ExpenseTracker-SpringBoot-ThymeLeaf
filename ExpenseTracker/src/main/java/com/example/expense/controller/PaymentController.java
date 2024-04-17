package com.example.expense.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.expense.entity.Payment;
import com.example.expense.entity.Vendor;
import com.example.expense.services.PaymentService;

@Controller
public class PaymentController {
	
	@Autowired
	PaymentService pserv;
	
	@PostMapping("/addPay")
	public String addPay(@ModelAttribute Payment pay) {
		pserv.addPay(pay);
		return "redirect:/map-Pview";
	}
	 
    @GetMapping("/map-Pview")
    public String viewPay(Model model) {
        List<Payment> plist = pserv.viewPay();
        model.addAttribute("plist", plist);
        return "payment"; 
    }
    


    @GetMapping("/Pupdate/{id}") // Corrected path variable
    public String showUpdatePaymentForm(@PathVariable("id") int id, Model model) {
        Payment payment = pserv.getPaymentById(id);
        model.addAttribute("payment", payment);
        return "updatePayment";
    }

    @PostMapping("/Pupdate/{id}") // Changed to PostMapping
    public String updatePayment(@PathVariable("id") int id, @ModelAttribute("payment") Payment payment) {
        payment.setPid(id); // Set the id explicitly
        pserv.updatePayment(payment);
        return "redirect:/map-Pview"; // Redirect to the view category page
    }
    

    @PostMapping("/Pdelete/{id}")
    public String deletePayment(@PathVariable("id") int id) {
        pserv.deletePaymentById(id);
        return "redirect:/map-Pview"; // Redirect to the view category page
    }



}
