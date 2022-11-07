package com.example.datn_motel_project.entity;

import com.example.datn_motel_project.entity.base.BaseEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

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
    private int count;
    private String price;
    @ManyToMany
    @JoinTable(name = "motel_limit_gender",
            joinColumns = @JoinColumn(name = "motel_id"),
            inverseJoinColumns = @JoinColumn(name = "gender_id")
    )
    private Set<Gender> limitGenders;
    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;


    @OneToMany(mappedBy = "")
    private Set<MotelTransaction> motelTransactions;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private ProjectMotel projectMotel;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    @OneToOne
    @JoinColumn(name = "pay_info_id")
    private MotelPayInfoDetail motelPayInfoDetail;

    @ManyToMany
    @JoinTable(name = "motel_type_detail",
            joinColumns = @JoinColumn(name = "motel_id"),
            inverseJoinColumns = @JoinColumn(name = "type_id")
    )
    private Set<MotelType> motelType;

    @OneToMany(mappedBy = "motel")
    private Set<Image> images;

    @ManyToMany
    @JoinTable(name = "motel_amenities_detail",
            joinColumns = @JoinColumn(name = "motel_id"),
            inverseJoinColumns = @JoinColumn(name = "amenties")
    )
    private Set<Amenities> amenities;
}
