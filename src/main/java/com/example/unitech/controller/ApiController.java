package com.example.unitech.controller;

import com.example.unitech.model.*;
import com.example.unitech.repository.*;
import com.example.unitech.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ApiController {


    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestParam String pin) {
        UserService userService = new UserService();
        User newUser = userService.registerUser(pin);
        return ResponseEntity.ok(newUser);
    }

    @PostMapping("/login")
    public ResponseEntity<User> loginUser(@RequestParam String pin) {
        UserService userService = new UserService();
        User user = userService.loginUser(pin);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/accounts")
    public ResponseEntity<List<Account>> getActiveAccounts() {
        AccountService accountService = new AccountService();
        List<Account> activeAccounts = accountService.getActiveAccounts();
        return ResponseEntity.ok(activeAccounts);
    }


    @PostMapping("/transfer")
    public ResponseEntity<Transaction> makeTransfer(@RequestParam Long sourceAccountId,
                                                    @RequestParam Long targetAccountId,
                                                    @RequestParam BigDecimal amount) {
        AccountService accountService = new AccountService();
        TransactionService transactionService = new TransactionService();
        Account sourceAccount = accountService.findById(sourceAccountId)
                .orElseThrow(() -> new IllegalArgumentException("Source account not found"));
        Account targetAccount = accountService.findById(targetAccountId)
                .orElseThrow(() -> new IllegalArgumentException("Target account not found"));
        Transaction transaction = transactionService.makeTransfer(sourceAccount, targetAccount, amount);
        return ResponseEntity.ok(transaction);
    }

    @GetMapping("/currencyRate")
    public ResponseEntity<BigDecimal> getCurrencyRate(@RequestParam String currencyPair) {
        CurrencyRateService currencyRateService = new CurrencyRateService();
        BigDecimal rate = currencyRateService.getCurrencyRate(currencyPair);
        return ResponseEntity.ok(rate);
    }
}
