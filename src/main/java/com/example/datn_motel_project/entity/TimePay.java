package com.example.datn_motel_project.entity;

import com.example.datn_motel_project.entity.base.BaseEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class TimePay extends BaseEntity {
    private String typeTime;

    @OneToMany(mappedBy = "timePay")
    private Set<MotelPayInfoDetail> motelPayInfoDetail;
}
