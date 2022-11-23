package com.example.datn_motel_project.service.impl;

import com.example.datn_motel_project.entity.Account;
import com.example.datn_motel_project.entity.Role;
import com.example.datn_motel_project.repository.AccountRepository;
import com.example.datn_motel_project.repository.RoleRepository;
import com.example.datn_motel_project.security.AccountDetail;
import com.example.datn_motel_project.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository.findAccountByEmail(username);
        if(account == null){
            throw new UsernameNotFoundException(username);
        }
        accountRepository.findById(account.getId()).get().getRoles();
        List<GrantedAuthority> authorities = roleRepository.findAllRoleByAccountId(account.getId()).stream().map(
                role -> new SimpleGrantedAuthority(role.getRoleName())
        ).collect(Collectors.toList());
        return new AccountDetail(account, authorities);
    }
    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Set<Role> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getRoleName())).collect(Collectors.toList());
    }

    @Override
    public Optional<Account> findById(Long id) {
        return accountRepository.findById(id);
    }
}
