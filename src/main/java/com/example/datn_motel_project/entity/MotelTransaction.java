package com.example.datn_motel_project.entity;

import com.example.datn_motel_project.entity.base.BaseEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class MotelTransaction extends BaseEntity {
    @OneToMany
    private Set<AccountTransactionDetail> accountTransactionDetailSet ;

    @ManyToOne
    @JoinColumn(name = "motel_id")
    private Motel motel;

    private String typePay;

    private int motelCount;

    private boolean flagDone;

    private Date deadline;

    private String totalPrice;

}
