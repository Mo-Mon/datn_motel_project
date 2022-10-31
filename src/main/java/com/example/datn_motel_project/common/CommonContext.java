package com.example.datn_motel_project.common;

import com.example.datn_motel_project.form.HeaderForm;
import com.example.datn_motel_project.entity.Account;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonContext {
    private Account account;
    private HeaderForm headerFormDto;
}
