package com.example.myproject.controller;

import com.example.myproject.model.ErrorLog;
import com.example.myproject.model.Users;
import com.example.myproject.service.ErrorService;
import com.example.myproject.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class errorDetailsController {

    @Autowired
    ErrorService errorService;

    @Autowired
    UserService userService;

    @GetMapping("/error-details/{errorId}")
    public String showErrorDetails(@PathVariable Long errorId, Model model) {
        try {
            Users user = userService.getAuthenticated();
            
            // Get error details
            Object result = errorService.findById(errorId, user);
            
            // Simple list check and conversion
            ErrorLog error = null;
            if (result instanceof List) {
                List<?> errorList = (List<?>) result;
                if (!errorList.isEmpty() && errorList.get(0) instanceof ErrorLog) {
                    error = (ErrorLog) errorList.get(0);
                }
            }
            
            if (error == null) {
                return "redirect:/dashboard?error=Error+not+found";
            }
            
            model.addAttribute("error", error);
            return "error-details";
            
        } catch (Exception e) {
            return "redirect:/dashboard?error=Error+loading+details";
        }
    }
}
