package com.example.datn_motel_project.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListMotelForm {
    private String inputTitle;
    private String inputProject;
    private String location;
    private String typePay;
    private List<String> listPriceRange;
    private List<String> listMotelType;
    private List<String> listAmenitiesIn;
    private List<String> listAmenitiesOut;
    private String size;
}
