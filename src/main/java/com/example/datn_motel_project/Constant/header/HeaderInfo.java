package com.example.datn_motel_project.Constant.header;
import lombok.Getter;

@Getter
public enum HeaderInfo {
    NOTE("note",new ScreenInfo[]{ScreenInfo.Login});
    String headerName;
    ScreenInfo[] screens;

    HeaderInfo(String s, ScreenInfo[] lists) {
        this.headerName = s;
        this.screens = lists;
    }
}
