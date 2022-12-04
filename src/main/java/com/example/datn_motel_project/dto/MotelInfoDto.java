package com.example.datn_motel_project.dto;

import com.example.datn_motel_project.entity.Amenities;
import com.example.datn_motel_project.entity.Image;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MotelInfoDto {
    private Long id;
    private String title;
    private String shortContent;
    private String content;
    private Integer maxPeople;
    private Integer countBedroom;
    private Integer countWC;
    private Float area;
    private Integer count;
    private Integer countHired;
    private String status;
    private Set<Image> listImage = new LinkedHashSet<>();
    private Set<String> limitGenders = new LinkedHashSet<>();
    private Set<String> listMotelType = new LinkedHashSet<>();
    private Set<Amenities> listAmenities = new LinkedHashSet<>();
    private String locationName;
    private Long price;
    private String typePay;
    private String projectType;
    private String nameUserPort;
    private Date timePort;
}
