package com.example.datn_motel_project.controller;

import com.example.datn_motel_project.dto.AccountInfoDto;
import com.example.datn_motel_project.dto.MotelInfoDto;
import com.example.datn_motel_project.form.MotelDetailInfoForm;
import com.example.datn_motel_project.service.MotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
public class MotelDetailInfoController {
    @Autowired
    private MotelService motelService;

    @GetMapping("/motelDetailInfo/{id}")
    public String showView(@PathVariable Optional<String> id, Model model){
        MotelInfoDto motelInfoDto = motelService.getMotelInfoById(Long.parseLong(id.get()));
        AccountInfoDto accountInfoDto = motelService.getAccountPortMotel(Long.parseLong(id.get()));
        MotelDetailInfoForm motelDetailInfoForm = new MotelDetailInfoForm();
        motelDetailInfoForm.setMotelInfoDto(motelInfoDto);
        motelDetailInfoForm.setListImageOld(motelInfoDto.getListImage());
        motelDetailInfoForm.setAccountInfoDto(accountInfoDto);
        motelDetailInfoForm.setMode("view");
        model.addAttribute("motelDetailInfoForm",motelDetailInfoForm);
        return "moteldetailinfor";
    }
}
