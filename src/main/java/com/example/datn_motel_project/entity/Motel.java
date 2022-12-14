package com.example.datn_motel_project.entity;

import com.example.datn_motel_project.entity.base.BaseEntity;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Getter
@Setter
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
    private int countHired;
    private Integer status;
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name = "motel_limit_gender",
            joinColumns = @JoinColumn(name = "motel_id"),
            inverseJoinColumns = @JoinColumn(name = "gender_id")
    )
    private Set<Gender> limitGenders = new LinkedHashSet<>();
    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;


    @OneToMany(mappedBy = "motel",cascade = CascadeType.ALL)
    private Set<MotelTransaction> motelTransactions;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private ProjectMotel projectMotel;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    @OneToMany(mappedBy = "motel",cascade = CascadeType.ALL)
    private Set<MotelPayInfoDetail> motelPayInfoDetails = new LinkedHashSet<>();

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name = "motel_type_detail",
            joinColumns = @JoinColumn(name = "motel_id"),
            inverseJoinColumns = @JoinColumn(name = "type_id")
    )
    private Set<MotelType> motelTypes = new HashSet<>();

    @OneToMany(mappedBy = "motel")
    private Set<Image> images = new LinkedHashSet<>();

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name = "motel_amenities_detail",
            joinColumns = @JoinColumn(name = "motel_id"),
            inverseJoinColumns = @JoinColumn(name = "amenties_id")
    )
    private Set<Amenities> amenities = new LinkedHashSet<>();
}
