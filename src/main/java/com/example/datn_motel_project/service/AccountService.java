package com.example.datn_motel_project.service;

import com.example.datn_motel_project.dto.AccountInfoDto;
import com.example.datn_motel_project.entity.Account;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface AccountService extends UserDetailsService {
    public Optional<Account>  findById(Long id);

    AccountInfoDto getAccountInfo(Long id);
}
