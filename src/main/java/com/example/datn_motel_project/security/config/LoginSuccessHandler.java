package com.example.datn_motel_project.security.config;

import com.example.datn_motel_project.security.AccountDetail;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Component
public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        AccountDetail accountDetail = (AccountDetail) authentication.getPrincipal();
        Long id = accountDetail.getId();
        HttpSession session = request.getSession();
        session.setAttribute("accountId",id);
        System.out.println("hello "+ accountDetail.getEmail());
        RequestDispatcher dd = request.getRequestDispatcher("/start");
        dd.forward(request, response);
        super.onAuthenticationSuccess(request, response, authentication);
    }
}
