package com.example.datn_motel_project.entity;

import com.example.datn_motel_project.entity.base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Account extends BaseEntity {
    private String email;
    @JsonIgnore
    private String password;
    private String phone;
    private String fullName;
    private String address;
    private Date dateOfBirth;
    private String idCard;
    private String pathIdCard;
    @ManyToMany(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    @JsonIgnore
    private Set<Role> roles = new LinkedHashSet<>();

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private Set<Motel> motels = new LinkedHashSet<>();

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private Set<AccountTransactionDetail> accountTransactionDetails = new LinkedHashSet<>();

    @ManyToOne
    @JoinColumn(name = "gender_id")
    private Gender gender;

}
