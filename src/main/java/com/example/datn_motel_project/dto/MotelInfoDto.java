package com.example.datn_motel_project.dto;

import com.example.datn_motel_project.entity.Amenities;
import com.example.datn_motel_project.entity.Image;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MotelInfoDto {
    private Long id;
    private String title;
    private String shortContent;
    private String content;
    private int maxPeople;
    private int countBedroom;
    private int countWC;
    private float area;
    private int count;
    private int countHired;
    private Set<Image> listImage;
    private Set<String> limitGenders;
    private Set<String> listMotelType;
    private Set<Amenities> listAmenities;
    private String locationName;
    private Long price;
    private String typePay;
    private String projectType;
    private String nameUserPort;
    private Date timePort;
}
