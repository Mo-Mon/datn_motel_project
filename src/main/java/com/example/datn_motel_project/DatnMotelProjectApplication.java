package com.example.datn_motel_project;

import com.example.datn_motel_project.common.BaseData;
import com.example.datn_motel_project.entity.Account;
import com.example.datn_motel_project.entity.Role;
import com.example.datn_motel_project.repository.AccountRepository;
import com.example.datn_motel_project.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

@SpringBootApplication
public class DatnMotelProjectApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(DatnMotelProjectApplication.class, args);
    }
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Override
    public void run(String... args) throws Exception {
//        Account account = new Account();
//        account.setAccountName("sonmnt@g");
//        account.setFullName("Mai Ngọc Tùng Sơn");
//        account.setIdCard("12345678");
//        account.setPathIdCard("");
//        account.setPhone("0981721306");
//        account.setPassword(passwordEncoder.encode("123456"));
//        account.setCreateAt(new Date());
//        account.setUpdateAt(new Date());
//        account.setUpdateBy("sonmnt");
//        account.setDeleteFlag(false);
//        account.setCreateBy("sonmnt");
//        Role role = new Role();
//        role.setRoleName("ROLE_USER");
//        BaseData.setInfoAccountCreate(account,role);
//        roleRepository.save(role);
//        account.getRoles().add(role);
//        accountRepository.save(account);
    }
}
