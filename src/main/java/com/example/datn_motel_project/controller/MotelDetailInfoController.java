package com.example.datn_motel_project.controller;

import com.example.datn_motel_project.dto.MotelInfoDto;
import com.example.datn_motel_project.form.MotelDetailInfoForm;
import com.example.datn_motel_project.service.MotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MotelDetailInfoController {
    @Autowired
    private MotelService motelService;

    @GetMapping("/motelDetailInfo/{id}")
    public String showView(@PathVariable String id, Model model){
        MotelInfoDto motelInfoDto = motelService.getMotelInfoById(Long.parseLong(id));
        MotelDetailInfoForm motelDetailInfoForm = new MotelDetailInfoForm();
        model.addAttribute("accountInfoDto",motelService.getAccountPortMotel(Long.parseLong(id)));
        model.addAttribute("motelInfoDto",motelInfoDto);
        return "moteldetailinfor";
    }
}
