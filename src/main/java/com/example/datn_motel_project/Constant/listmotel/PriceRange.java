package com.example.datn_motel_project.Constant.listmotel;

import lombok.Getter;

@Getter
public enum PriceRange {
    PRICE_RANGE_1(1,1500000,2500000),
    PRICE_RANGE_2(2,2500000,3500000),
    PRICE_RANGE_3(3,3500000,4000000),
    PRICE_RANGE_4(4,4000000,6000000),
    PRICE_RANGE_5(5,6000000,8500000),
    PRICE_RANGE_6(6,8500000,10000000),
    PRICE_RANGE_7(7,10000000,2147483647);

    int id;
    int min;
    int max;

    PriceRange(int id, int min, int max) {
        this.id = id;
        this.min = min;
        this.max = max;
    }
}
