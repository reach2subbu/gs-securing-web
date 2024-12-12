package com.example.securingweb;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/account")
public class AccountController {

    @PostMapping("/savings-balance")
    public String checkSavingsBalance(@RequestParam String accountNumber, Model model) {
        // Logic to check savings account balance
        String balance = "Savings account balance for account " + accountNumber + " is $ " + Math.round(Math.random() * 10000);
        model.addAttribute("balance", balance);
        return "savingbalance";
    }

    @PostMapping("/transaction-statement")
    public String getTransactionStatement(@RequestParam String accountNumber, @RequestParam(required = false) String fromDate, @RequestParam (required = false) String toDate, Model model) {
        // Logic to retrieve transaction statement
        String statement = "Transaction statement for account " + accountNumber + " from " + fromDate + " to " + toDate + " is ... Nothing";
        model.addAttribute("statement", statement);
        return "transactionstatement";
    }

    @PostMapping("/checking-balance")
    public String checkCheckingBalance(@RequestParam String accountNumber, Model model) {
        // Logic to check checking account balance
        String balance = "Checking account balance for account " + accountNumber + " is $ " + Math.round(Math.random() * 10000);
        model.addAttribute("balance", balance);
        return "checkingbalance";
    }
}
