package com.example.datn_motel_project.Constant.header;

import lombok.Getter;

@Getter
public enum ScreenInfo {
    Login( "Login Page", "/login", RoleInfo.USER.getRoleName()),

    MANAGER_MOTEL_SELLER("quản lý trọ (người bán)","/seller/managerMotel", RoleInfo.SELLER.getRoleName());

    private String roles;

    private String pageName;

    private String link;

    ScreenInfo( String s, String s1,String i) {
        this.roles = i;
        this.pageName = s;
        this.link = s1;
    }
}
