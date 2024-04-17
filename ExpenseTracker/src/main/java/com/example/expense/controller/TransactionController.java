package com.example.expense.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.expense.entity.Category;
import com.example.expense.entity.Payment;
import com.example.expense.entity.Transaction;
import com.example.expense.entity.TransactionDTO;
import com.example.expense.entity.Vendor;
import com.example.expense.services.CategoryService;
import com.example.expense.services.PaymentService;
import com.example.expense.services.TransactionService;
import com.example.expense.services.VendorService;

@Controller
public class TransactionController {
	@Autowired
	TransactionService tserv;
	
	@Autowired
	CategoryService cserv;
	
	@Autowired
	VendorService vserv;
	
	@Autowired
	PaymentService pserv;
	
	
	@PostMapping("/addTrans")
	public String addTrans(@ModelAttribute TransactionDTO transactionDTO)
	                       {
	    
	    Category category = cserv.getCategoryById(transactionDTO.getTcat()); // Assuming you have a method to get Category by ID
	    Vendor vendor=vserv.getVendorById(transactionDTO.getTven());
	    Payment payment=pserv.getPaymentById(transactionDTO.getTpay());
	    
	    Transaction trans = new Transaction();
	    trans.setTid(transactionDTO.getTid());
	    trans.setTdate(transactionDTO.getTdate());
	    trans.setTcat(category.getCat_name());
	    trans.setParticulars(transactionDTO.getParticulars());
	    trans.setAmount(transactionDTO.getAmount());
	    trans.setTven(vendor.getVname());
	    trans.setTpay(payment.getPtype());
	    trans.setTdetails(transactionDTO.getTdetails());
	    trans.setRemarks(transactionDTO.getRemarks());
	    trans.setCategory(category);
	    trans.setVendor(vendor);
	    trans.setPayment(payment);
	    tserv.addTrans(trans);
	    
	    category.getTransactions().add(trans);
	    cserv.updateCat(category);
	    
	    vendor.getTransactions().add(trans);
	    vserv.updateVen(vendor);
	    
	    payment.getTransactions().add(trans);
	    pserv.updatePay(payment);
	    
	    return "redirect:/map-Tview";
	}

	 
    @GetMapping("/map-Tview")
    public String viewTrans(Model model) {
        List<Transaction> tlist = tserv.viewTrans();
        model.addAttribute("tlist", tlist);
        return "transaction"; 
    }
    


    @GetMapping("/Tupdate/{id}") // Corrected path variable
    public String showUpdateTransactionForm(@PathVariable("id") int id, Model model) {
    	List<Category> clist = cserv.viewCat();
        model.addAttribute("clist", clist);
        
        List<Vendor> vlist = vserv.viewVen();
        model.addAttribute("vlist", vlist);
        
        List<Payment> plist = pserv.viewPay();
        model.addAttribute("plist", plist);
        
        Transaction transaction = tserv.getTransactionById(id);
        TransactionDTO t=new TransactionDTO();
        t.setTid(transaction.getTid());
        t.setTdate(transaction.getTdate());
        t.setTcat(transaction.getCategory().getCid());
        t.setParticulars(transaction.getParticulars());
        t.setAmount(transaction.getAmount());
        t.setTven(transaction.getVendor().getVid());
        t.setTpay(transaction.getPayment().getPid());
        t.setTdetails(transaction.getTdetails());
        t.setRemarks(transaction.getRemarks());
        String categoryName = tserv.getCategoryName(id);
        
        String vendorName=tserv.getVendorName(id);
        
        String paymentType=tserv.getPaymentType(id);
        
        model.addAttribute("transactionDTO", t);
        model.addAttribute("categoryName",categoryName);
        model.addAttribute("vendorName",vendorName);
        model.addAttribute("paymentType",paymentType);
        return "updateTransaction";
    }

    @PostMapping("/Tupdate/{id}") // Changed to PostMapping
    public String updateTransaction(@PathVariable("id") int id, @ModelAttribute TransactionDTO transactionDTO) {
       
        Category category = cserv.getCategoryById(transactionDTO.getTcat()); // Assuming you have a method to get Category by ID
	    Vendor vendor=vserv.getVendorById(transactionDTO.getTven());
	    Payment payment=pserv.getPaymentById(transactionDTO.getTpay());
	    
	    Transaction trans = new Transaction();
	    trans.setTid(transactionDTO.getTid());
	    trans.setTdate(transactionDTO.getTdate());
	    trans.setTcat(category.getCat_name());
	    trans.setParticulars(transactionDTO.getParticulars());
	    trans.setAmount(transactionDTO.getAmount());
	    trans.setTven(vendor.getVname());
	    trans.setTpay(payment.getPtype());
	    trans.setTdetails(transactionDTO.getTdetails());
	    trans.setRemarks(transactionDTO.getRemarks());
	    trans.setCategory(category);
	    trans.setVendor(vendor);
	    trans.setPayment(payment);
        tserv.updateTransaction(trans);
        
      /*  category.getTransactions().add(trans);
	    cserv.updateCat(category);
	    
	    vendor.getTransactions().add(trans);
	    vserv.updateVen(vendor);
	    
	    payment.getTransactions().add(trans);
	    pserv.updatePay(payment);*/
        return "redirect:/map-Tview"; // Redirect to the view category page
    }
    

    @PostMapping("/Tdelete/{id}")
    public String deleteTransaction(@PathVariable("id") int id) {
        tserv.deleteTransactionById(id);
        return "redirect:/map-Tview"; // Redirect to the view category page
    }



}
