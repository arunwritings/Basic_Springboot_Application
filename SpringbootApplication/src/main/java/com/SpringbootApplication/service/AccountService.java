package com.SpringbootApplication.service;

import com.SpringbootApplication.entity.AccountEN;
import com.SpringbootApplication.model.AccountIO;
import org.springframework.http.ResponseEntity;

public interface AccountService {

    public String createAccount(AccountIO accountIO);

    public String updateAccount(AccountIO accountIO);

    public AccountIO getAccountDetails(Long accountNumber);

    public String deleteAccount(Long accountNumber);
}
