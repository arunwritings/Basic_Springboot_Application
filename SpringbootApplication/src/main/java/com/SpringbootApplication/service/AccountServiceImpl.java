package com.SpringbootApplication.service;

import com.SpringbootApplication.entity.AccountEN;
import com.SpringbootApplication.model.AccountIO;
import com.SpringbootApplication.repository.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepo accountRepo;

    @Override
    public String createAccount(AccountIO accountIO) {
        AccountEN accountEN = new AccountEN();
        accountEN.setAccountNumber(accountIO.getAccountNumber());
        accountEN.setCustomerName(accountIO.getCustomerName());
        accountEN.setCustomerAddress(accountIO.getCustomerAddress());
        accountEN.setPhoneNumber(accountIO.getPhoneNumber());
        accountRepo.save(accountEN);
        return "Successfully created";
    }

    @Override
    public String updateAccount(AccountIO accountIO) {
        AccountEN accountEN = accountRepo.findByAccountNumber(accountIO.getAccountNumber());
        if (accountEN!=null){
            accountEN.setAccountNumber(accountIO.getAccountNumber());
            accountEN.setCustomerName(accountIO.getCustomerName());
            accountEN.setCustomerAddress(accountIO.getCustomerAddress());
            accountEN.setPhoneNumber(accountIO.getPhoneNumber());
            accountRepo.save(accountEN);
            return "Successfully Updated";
        }else {
            return createAccount(accountIO);
        }
    }

    @Override
    public AccountIO getAccountDetails(Long accountNumber) {
        AccountEN accountEN = accountRepo.findByAccountNumber(accountNumber);
        if (accountEN!=null){
            AccountIO accountIO = new AccountIO();
            accountIO.setAccountNumber(accountEN.getAccountNumber());
            accountIO.setCustomerName(accountEN.getCustomerName());
            accountIO.setCustomerAddress(accountEN.getCustomerAddress());
            accountIO.setPhoneNumber(accountEN.getPhoneNumber());
            return accountIO;
        }else {
            return null;
        }
    }

    @Override
    public String deleteAccount(Long accountNumber) {
        AccountEN accountEN = accountRepo.findByAccountNumber(accountNumber);
        if (accountEN!=null){
            accountRepo.delete(accountEN);
            return "Successfully deleted";
        }
        return "Account doesn't exist";
    }
}
