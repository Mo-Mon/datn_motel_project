package com.example.datn_motel_project.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ListMotelManagerForm {
    private String inputTitle = "";
    private String inputProject = "";
    private String location = "";
    private String timePay = "";
    private String startDate = "";
    private String endDate = "";
    private List<Integer> listPriceRange = new ArrayList<>();
    private List<String> listMotelType = new ArrayList<>();
    private List<String> listAmenitiesIn = new ArrayList<>();
    private List<String> listAmenitiesOut = new ArrayList<>();
    private List<Integer> listStatus = new ArrayList<>();
    private List<Long> listId = new ArrayList<>();
    private Integer size = 0 ;
    private Integer pageCurrent = 1;
}
