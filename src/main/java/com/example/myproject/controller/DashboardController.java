package com.example.myproject.controller;

import com.example.myproject.model.ErrorLog;
import com.example.myproject.model.Project;
import com.example.myproject.model.Users;
import com.example.myproject.service.ErrorService;
import com.example.myproject.service.ProjectService;
import com.example.myproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class DashboardController {

    @Autowired
    private ErrorService errorService;

    @Autowired
    private UserService userService;

    @Autowired
    private ProjectService projectService;

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        Users user = userService.getAuthenticated();
        List<Project> projects = projectService.getProjectByUser(user);
        model.addAttribute("projects", projects);
        return "dashboard";
    }

}
