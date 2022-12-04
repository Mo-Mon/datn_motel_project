package com.example.datn_motel_project.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddMotelForm {
    private String titleMode;
    private String key;
    private String title;
    private String shortContent;
    private String content;
    private Integer maxPeople;
    private Integer countBedroom;
    private Integer countWC;
    private Float area;
    private Integer count;
    private Integer countHired;
    private List<Long> limitGendersId;
    private List<Long> listMotelTypeId;
    private List<Long> listAmenitiesIn;
    private List<Long> listAmenitiesOut;
    private Long locationId;
    private Long price;
    private Long deposits;
    private Long typePayId;
    private Long projectMotelId;

    public AddMotelForm(String titleMode,String key){
        this.titleMode = titleMode;
        this.key = key;
    }
}
