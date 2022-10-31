package com.example.datn_motel_project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class ListMotelController {
    @GetMapping("/home")
    public String goHome(HttpSession session, Model model) {
        return "/listmotel";
    }
}
