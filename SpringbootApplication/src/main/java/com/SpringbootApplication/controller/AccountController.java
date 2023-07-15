package com.SpringbootApplication.controller;

import com.SpringbootApplication.model.AccountIO;
import com.SpringbootApplication.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/create")
    public String createAccount(@RequestBody AccountIO accountIO){
            return this.accountService.createAccount(accountIO);
        }

    @PutMapping("/update")
    public String updateAccount(@RequestBody AccountIO accountIO){
            accountService.updateAccount(accountIO);
            return this.accountService.updateAccount(accountIO);
        }

    @GetMapping("/retrieve")
    public AccountIO getAccountDetails(@RequestParam Long accountNumber){
            return this.accountService.getAccountDetails(accountNumber);
        }

    @DeleteMapping("/delete")
    public String deleteAccount(@RequestParam Long accountNumber){
        return this.accountService.deleteAccount(accountNumber);
    }
}
