package com.example.datn_motel_project.Constant.header;
import lombok.Getter;

@Getter
public enum HeaderInfo {
    NOTE("note",new ScreenInfo[]{ScreenInfo.Login}),
    MANAGER_MOTEL("quản lý nhà trọ", new ScreenInfo[]{ScreenInfo.MANAGER_MOTEL_SELLER});
    String headerName;
    ScreenInfo[] screens;

    HeaderInfo(String s, ScreenInfo[] lists) {
        this.headerName = s;
        this.screens = lists;
    }
}
