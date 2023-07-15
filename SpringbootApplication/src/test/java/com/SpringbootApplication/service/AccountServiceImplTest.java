package com.SpringbootApplication.service;

import com.SpringbootApplication.entity.AccountEN;
import com.SpringbootApplication.model.AccountIO;
import com.SpringbootApplication.repository.AccountRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class AccountServiceImplTest {

    @InjectMocks
    AccountServiceImpl accountServiceImpl;

    @Mock
    AccountRepo accountRepo;

    @Test
    void createAccount() {
        Assertions.assertEquals("Successfully created",accountServiceImpl.createAccount(getAccountIO()));
    }

    @Test
    void updateAccountForNotNull() {
        Mockito.when(accountRepo.findByAccountNumber(Mockito.anyLong())).thenReturn(getAccountEN());
        Assertions.assertEquals("Successfully Updated",accountServiceImpl.updateAccount(getAccountIO()));
    }

    @Test
    void updateAccountWhenNull(){
        Mockito.when(accountRepo.findByAccountNumber(Mockito.anyLong())).thenReturn(null);
        Assertions.assertEquals("Successfully created",accountServiceImpl.updateAccount(getAccountIO()));
    }

    @Test
    void getAccountDetailsForNotNull() {
        Mockito.when(accountRepo.findByAccountNumber(Mockito.anyLong())).thenReturn(getAccountEN());
        Assertions.assertEquals("arun",accountServiceImpl.getAccountDetails(123434L).getCustomerName());
    }

    @Test
    void getAccountDetailsWhenNull(){
        Mockito.when(accountRepo.findByAccountNumber(Mockito.anyLong())).thenReturn(null);
        Assertions.assertNull(accountServiceImpl.getAccountDetails(123434L));
    }

    @Test
    void deleteAccountForNotNull() {
        Mockito.when(accountRepo.findByAccountNumber(Mockito.anyLong())).thenReturn(getAccountEN());
        Assertions.assertEquals("Successfully deleted",accountServiceImpl.deleteAccount(123434L));
    }

    @Test
    void deleteAccountWhenNull() {
        Mockito.when(accountRepo.findByAccountNumber(Mockito.anyLong())).thenReturn(null);
        Assertions.assertEquals("Account doesn't exist",accountServiceImpl.deleteAccount(123434L));
    }

   AccountEN getAccountEN(){
       AccountEN accountEN = new AccountEN();
       accountEN.setSerialNumber(1);
       accountEN.setAccountNumber(123434L);
       accountEN.setCustomerName("arun");
       accountEN.setCustomerAddress("Kolar");
       accountEN.setPhoneNumber(12324L);
       return accountEN;
    }

    AccountIO getAccountIO(){
        AccountIO accountIO  = new AccountIO();
        accountIO.setAccountNumber(123434L);
        accountIO.setCustomerName("arun");
        accountIO.setCustomerAddress("Kolar");
        accountIO.setPhoneNumber(12324L);
        return accountIO;
    }
}