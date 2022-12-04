package com.example.datn_motel_project.dto;

import lombok.Data;

@Data
public class FileSessionDto {

    private byte[] data;

    private String fileName;

    private Long size;

    public Boolean isEmpty(){
        Boolean flag = false;
        if(data != null || data.length == 0){
            flag = true;
        }
        return flag;
    }
}
