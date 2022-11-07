package com.example.datn_motel_project.entity;

import com.example.datn_motel_project.entity.base.BaseEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
@Data
@NoArgsConstructor
public class MotelPayInfoDetail extends BaseEntity {
    private String price;
    private String deposits;
    @OneToOne(mappedBy = "motelPayInfoDetail")
    private Motel motel;

    @ManyToOne
    @JoinColumn(name = "time_pay_id")
    private TimePay timePay;
}
