package com.example.datn_motel_project.Constant.listmotel;

import lombok.Getter;

@Getter
public enum AmenitiesOutConstant {
    POOL(0,"bể bơi","pool"),
    FreeParking(1,"miễn phí chổ để xe","free_parking");
    private int id;
    private String title;
    private String name;

    AmenitiesOutConstant(int id,String title, String name) {
        this.id = id;
        this.title = title;
        this.name = name;
    }
}
