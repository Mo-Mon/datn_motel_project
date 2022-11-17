package com.example.datn_motel_project;

import com.example.datn_motel_project.Constant.listmotel.AmenitiesInConstant;
import com.example.datn_motel_project.common.BaseLogic;
import com.example.datn_motel_project.entity.*;
import com.example.datn_motel_project.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;

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

    @Autowired
    MotelTypeRepository motelTypeRepository;

    @Autowired
    AmenitiesRepository amenitiesRepository;

    @Autowired
    MotelRepository motelRepository;

    @Autowired
    ProjectMotelRepository projectMotelRepository;

    @Autowired
    ImageRepository imageRepository;

    @Autowired
    TimePayRepository timePayRepository;
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
//        BaseLogic.setInfoAccountCreate(account,account);
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
//        MotelType m1 = new MotelType();
//        m1.setName("chung cư");
//        BaseLogic.setInfoAccountCreate(a,m1);
//        motelTypeRepository.save(m1);
//        MotelType m2 = new MotelType();
//        m2.setName("chung cư mini");
//        BaseLogic.setInfoAccountCreate(a,m2);
//        motelTypeRepository.save(m2);
//        MotelType m3 = new MotelType();
//        m3.setName("nhà trọ tập thể");
//        BaseLogic.setInfoAccountCreate(a,m3);
//        motelTypeRepository.save(m3);
//        MotelType m4 = new MotelType();
//        m4.setName("homestay");
//        BaseLogic.setInfoAccountCreate(a,m4);
//        motelTypeRepository.save(m4);
//
//        Amenities am1 = new Amenities();
//        am1.setName(AmenitiesInConstant.WIFI.name());
//        BaseLogic.setInfoAccountCreate(a,am1);
//        amenitiesRepository.save(am1);
//
//        Gender g = genderRepository.findById(2L).get();
//
//
//
//        Location l = locationRepository.findById(5L).get();
//        ProjectMotel projectMotel = new ProjectMotel();
//        projectMotel.setName("nhà ở xa hội");
//        BaseLogic.setInfoAccountCreate(a,projectMotel);
//        projectMotelRepository.save(projectMotel);
//
//
//        ProjectMotel projectMotel1 = projectMotelRepository.findById(15L).get();
//        Motel motel = new Motel();
//        BaseLogic.setInfoAccountCreate(a,motel);
//        motel.setAccount(a);
//        motel.setTitle("nhà trọ giá rẻ khu Chùa Láng Hà Nội");
//        motel.setShortContent("giá rẻ nhanh tay lên bạn ơi");
//        motel.setContent("nhà trọ này bao gồm rất nhiều tiện ích hay ho rông rãi thoài mái ");
//        motel.setMaxPeople(2);
//        motel.setCountBedroom(1);
//        motel.setCountWC(1);
//        motel.setArea(25);
//        motel.setCount(2);
//        motel.setProjectMotel(projectMotel1);
//        MotelType mmm = motelTypeRepository.findById(11L).get();
//        Set<MotelType> smt = motel.getMotelTypes();
//        smt.add(motelTypeRepository.findById(11L).get());
//        smt.add(motelTypeRepository.findById(12L).get());
//        motel.setMotelTypes(smt);
//        motelRepository.save(motel);
//
//        TimePay timePay = new TimePay();
//        BaseLogic.setInfoAccountCreate(a, timePay);
//        timePay.setTypeTime("Tháng");
//        timePayRepository.save(timePay);
    }
}
