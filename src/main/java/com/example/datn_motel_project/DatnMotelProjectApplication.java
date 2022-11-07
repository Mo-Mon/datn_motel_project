package com.example.datn_motel_project;

import com.example.datn_motel_project.common.BaseLogic;
import com.example.datn_motel_project.entity.Account;
import com.example.datn_motel_project.entity.Gender;
import com.example.datn_motel_project.entity.Location;
import com.example.datn_motel_project.entity.Role;
import com.example.datn_motel_project.repository.AccountRepository;
import com.example.datn_motel_project.repository.GenderRepository;
import com.example.datn_motel_project.repository.LocationRepository;
import com.example.datn_motel_project.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

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
    GenderRepository genderRepository;
    @Autowired
    LocationRepository locationRepository;

    @Autowired
    PasswordEncoder passwordEncoder;
    @Override
    public void run(String... args) throws Exception {

//        Account account = new Account();
//        account.setEmail("sonmnt@gmail.com");
//        account.setFullName("Mai Ngọc Tùng Sơn");
//        account.setAddress("Hà Nội");
//        account.setIdCard("12345678");
//        account.setPathIdCard("");
//        account.setPhone("0981721306");
//        account.setDateOfBirth(BaseLogic.getStringToDate("25/10/1999"));
//        account.setPassword(passwordEncoder.encode("123456"));
//        Role role = new Role();
//        role.setRoleName("ROLE_USER");
//        BaseLogic.setInfoAccountCreate(account,role);
//        roleRepository.save(role);
//        Gender male = new Gender();
//        male.setName("male");
//        BaseLogic.setInfoAccountCreate(account,male);
//        genderRepository.save(male);
//        Gender female = new Gender();
//        female.setName("famale");
//        BaseLogic.setInfoAccountCreate(account,female);
//        genderRepository.save(female);
//        account.setGender(male);
//        account.getRoles().add(role);
//        accountRepository.save(account);
//
//        Account a = accountRepository.findAccountByEmail("sonmnt@gmail.com");
//        Location l1 = new Location();
//        l1.setName("Hà Nội");
//        BaseLogic.setInfoAccountCreate(a,l1);
//        locationRepository.save(l1);
//        Location l2 = new Location();
//        l2.setName("Hồ Chí Mình");
//        BaseLogic.setInfoAccountCreate(a,l2);
//        locationRepository.save(l2);
//        Location l3 = new Location();
//        l3.setName("Đà Nẵng");
//        BaseLogic.setInfoAccountCreate(a,l3);
//        locationRepository.save(l3);
//        Location l4 = new Location();
//        l4.setName("Thanh Hóa");
//        BaseLogic.setInfoAccountCreate(a,l4);
//        locationRepository.save(l4);
//        Location l5 = new Location();
//        l5.setName("Thái Bình");
//        BaseLogic.setInfoAccountCreate(a,l5);
//        locationRepository.save(l5);
    }
}
