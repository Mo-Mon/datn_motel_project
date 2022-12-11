package com.example.datn_motel_project.form;

import com.example.datn_motel_project.dto.AccountInfoDto;
import com.example.datn_motel_project.dto.MotelInfoDto;
import com.example.datn_motel_project.entity.Image;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MotelDetailInfoForm {
    private MotelInfoDto motelInfoDto;
    private String mode;
    private String key;
    private List<Image> listImageOld = new ArrayList<>();
    private List<Integer> listIdImageDelete = new ArrayList<>();
    private AccountInfoDto accountInfoDto;
}
