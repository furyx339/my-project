package com.example.myproject.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/logout")
public class LogoutController {

    public String logout(HttpServletRequest request) {
       HttpSession session = request.getSession(false);
       if(session != null){
           session.invalidate();
       }

        SecurityContextHolder.clearContext();

       return "redirect:/login";
    }
}
