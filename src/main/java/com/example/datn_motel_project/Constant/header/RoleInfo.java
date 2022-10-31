package com.example.datn_motel_project.Constant.header;

import lombok.Getter;

@Getter
public enum RoleInfo {
    USER("ROLE_USER"),
    SELLER("ROLE_SELLER"),
    ADMIN("ROLE_ADMIN");
    String roleName;
    RoleInfo(String s){
        this.roleName = s;
    }
}
