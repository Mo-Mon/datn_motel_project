package com.example.datn_motel_project.dto;

import com.example.datn_motel_project.entity.Amenities;
import com.example.datn_motel_project.entity.Image;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MotelInfoDto {
    private String title;
    private String shortContent;
    private String content;
    private int maxPeople;
    private int countBedroom;
    private int countWC;
    private float area;
    private int count;
    private String price;
    private List<Image> listImage;
    private List<String> limitGenders;
    private List<String> listMotelType;
    private List<Amenities> listAmenities;
    private String locationName;
    private String typePay;
    private String projectType;
    private String nameUserPort;
}
