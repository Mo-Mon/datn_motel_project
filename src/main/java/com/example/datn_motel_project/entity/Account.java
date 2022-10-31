package com.example.datn_motel_project.entity;

import com.example.datn_motel_project.entity.base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Account extends BaseEntity {
    private String accountName;
    @JsonIgnore
    private String password;
    private String phone;
    private String fullName;
    private String idCard;
    private String pathIdCard;
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", //Tạo ra một join Table tên là "address_person"
            joinColumns = @JoinColumn(name = "user_id"),  // TRong đó, khóa ngoại chính là address_id trỏ tới class hiện tại (Address)
            inverseJoinColumns = @JoinColumn(name = "role_id") //Khóa ngoại thứ 2 trỏ tới thuộc tính ở dưới (Person)
    )
    @JsonIgnore
    private Set<Role> roles = new HashSet<>();


//    private List<Motel> motels = new ArrayList<>();
}
