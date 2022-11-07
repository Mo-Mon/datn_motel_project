package com.example.datn_motel_project.Constant.listmotel;

import lombok.Getter;

@Getter
public enum AmenitiesInConstant {
    WIFI(0,"Wifi","wifi")
    ,PET_ALLOW(1,"cho phép vật nuôi","pet_allow");
    private int id;
    private String title;
    private String name;

    AmenitiesInConstant(int id, String title, String name) {
        this.id = id;
        this.title = title;
        this.name = name;
    }
}
