package com.SpringbootApplication.repository;

import com.SpringbootApplication.entity.AccountEN;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepo extends JpaRepository<AccountEN,Long> {

    @Query("select a from AccountEN a where a.accountNumber = :accountNumber")
    AccountEN findByAccountNumber(Long accountNumber);
}
