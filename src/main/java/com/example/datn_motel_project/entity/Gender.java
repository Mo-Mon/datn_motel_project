package com.example.datn_motel_project.entity;

import com.example.datn_motel_project.entity.base.BaseEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;
@Entity
@NoArgsConstructor
@Data
public class Gender extends BaseEntity {
    private String name;
    @OneToMany(mappedBy = "gender", cascade = CascadeType.ALL)
    private Set<Account> accounts;
    @ManyToMany(mappedBy = "limitGenders", fetch = FetchType.EAGER)
    private Set<Motel> motels;
}
