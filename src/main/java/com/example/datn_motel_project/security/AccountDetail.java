package com.example.datn_motel_project.security;

import com.example.datn_motel_project.entity.Account;
import com.example.datn_motel_project.entity.Role;
import com.example.datn_motel_project.repository.AccountRepository;
import com.example.datn_motel_project.repository.RoleRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDetail implements UserDetails {
    private List<GrantedAuthority> authorities = null;
    private Long id;
    private String email;
    private String password;
    @Autowired
    public RoleRepository RoleRepository;
    public AccountDetail(Account account, List<GrantedAuthority> authorities){
        this.id = account.getId();
        this.password = account.getPassword();
        this.email = account.getAccountName();
        this.authorities = authorities;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
