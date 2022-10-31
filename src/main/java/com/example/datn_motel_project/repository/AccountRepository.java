package com.example.datn_motel_project.repository;

import com.example.datn_motel_project.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Long> {
    Account findAccountByAccountName(String accountName);
}
