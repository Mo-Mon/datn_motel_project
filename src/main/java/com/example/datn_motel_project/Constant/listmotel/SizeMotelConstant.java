package com.example.datn_motel_project.Constant.listmotel;

import lombok.Getter;

@Getter
public enum SizeMotelConstant {
    ROOM_M(0,10),
    ROOM_L(1,15),
    ROOM_XL(2,25),
    ROOM_XXL(3,35),
    APARTMENT_M(4, 40),
    APARTMENT_L(5,55),
    APARTMENT_XL(6,65),
    APARTMENT_XXL(7,80);

    private int id;
    private int size;

    SizeMotelConstant(int id, int size) {
        this.id = id;
        this.size = size;
    }
}
