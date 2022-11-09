package com.example.datn_motel_project.entity;

import lombok.Data;

import java.util.List;
@Data
public class PageCustomer<T> {
    private List<T> listObject;
    private Integer totalRecord;
    private Integer totalPage;
    private Integer page;
    private Integer limitRecordInPage;
}
