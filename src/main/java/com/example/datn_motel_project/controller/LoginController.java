package com.example.datn_motel_project.controller;

import com.example.datn_motel_project.common.CommonContext;
import com.example.datn_motel_project.form.HeaderForm;
import com.example.datn_motel_project.entity.Account;
import com.example.datn_motel_project.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    private AccountRepository accountRepository;

    @PostMapping("/start")
    public String start(HttpSession session){
        Account account = accountRepository.findById((Long)session.getAttribute("accountId")).get() ;
        CommonContext commonContext = new CommonContext(account, HeaderForm.build(account));
        session.setAttribute("context", commonContext);
        return "redirect:/home";
    }


    @GetMapping("/login")
    public String login() {
        return "login";
    }

}
