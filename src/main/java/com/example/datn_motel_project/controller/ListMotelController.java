package com.example.datn_motel_project.controller;

import com.example.datn_motel_project.Constant.listmotel.*;
import com.example.datn_motel_project.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ListMotelController {
    @Autowired
    private LocationService locationService;

    @GetMapping("/home")
    public String goHome(HttpSession session, Model model) {
        setupView(model);
        List<String> locations = locationService.getListLocation();
        model.addAttribute("listLocation",locations);
        return "/listmotel";
    }

    private void setupView(Model model){
        model.addAttribute("listPriceRange", PriceRange.values());
        model.addAttribute("listAmenitiesIn", AmenitiesInConstant.values());
        model.addAttribute("listAmenitiesOut", AmenitiesOutConstant.values());
        model.addAttribute("listSize", SizeMotelConstant.values());
    }

    private void getData(Model model){

    }
}
