package com.example.datn_motel_project.Constant.listmotel;

import lombok.Getter;

@Getter
public enum MotelTypeConstant {
    APARTMENT(0,"chung cư","apartment"),
    APARTMENT_MINI(1,"chung cư mini","apartment_mini"),
    DORMITORY(2,"nhà trọ tập thể","dormitory"),
    HOMESTAY(3,"homestay","homestay");

    private int id;
    private String title;
    private String name;

    MotelTypeConstant(int id, String title,String name) {
        this.id = id;
        this.title = title;
        this.name = name;
    }
}
