package com.example.datn_motel_project.controller;

import com.example.datn_motel_project.form.AdminMotelForm;
import com.example.datn_motel_project.service.LocationService;
import com.example.datn_motel_project.service.MotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class ManagerAdminMotelController {
    @Autowired
    private MotelService motelService;

    @Autowired
    private LocationService locationService;

    @GetMapping("/managerMotel")
    public String init(Model model, HttpSession session){
        AdminMotelForm adminMotelForm = new AdminMotelForm();
        model.addAttribute("adminMotelForm",adminMotelForm);
        setupView(model);
        return "adminmotel";
    }

    private void setupView(Model model) {
        List<String> locations = locationService.getListLocation();
        model.addAttribute("listLocation", locations);
    }

}
