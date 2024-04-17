package com.example.expense.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.expense.services.TransactionService;

@Controller
public class ReportController {

    @Autowired
    TransactionService transactionService;

    @GetMapping("/report")
    public String showReportForm() {
        return "report";
    }

    @PostMapping("/report")
    public String generateReport(@RequestParam("fromDate") String fromDateStr,
                                 @RequestParam("toDate") String toDateStr,
                                 Model model) {
        LocalDate fromDate = LocalDate.parse(fromDateStr);
        LocalDate toDate = LocalDate.parse(toDateStr);
        List<Object[]> transactions = transactionService.getTransactionReport(fromDate, toDate);
        model.addAttribute("transactions", transactions);
        return "report";
    }
}
