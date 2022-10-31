package com.example.datn_motel_project.entity;

import com.example.datn_motel_project.entity.base.BaseEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
public class Motel extends BaseEntity {
    private String title;
    private String shortContent;
    private String content;
    private int maxPeople;
    private int countBedroom;
    private int countWC;
    private float area;
}
