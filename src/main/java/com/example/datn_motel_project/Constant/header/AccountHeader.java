package com.example.datn_motel_project.Constant.header;

import lombok.Data;
import lombok.Getter;

@Getter
public enum AccountHeader {
    INFOACCOUNT("Thông tin chi tiết",""),
    SETTING("Cài Đặt","");
    String name;
    String link;

    AccountHeader(String s, String s1) {
        this.name = s;
        this.link = s1;
    }
}
