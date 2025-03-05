package com.example.myproject.controller;

import com.example.myproject.model.ErrorLog;
import com.example.myproject.model.Message;
import com.example.myproject.model.Project;
import com.example.myproject.model.Users;
import com.example.myproject.service.ErrorLogsResponse;
import com.example.myproject.service.ErrorService;
import com.example.myproject.service.ProjectService;
import com.example.myproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Errors")
@CrossOrigin(origins = "http://127.0.0.1:5501")
public class ErrorLogController {

    private final ErrorService errorService;
    private final UserService userService;
    private final ProjectService projectService;

    @Autowired
    public ErrorLogController(ErrorService errorService, UserService userService, ProjectService projectService) {
        this.errorService = errorService;
        this.userService = userService;
        this.projectService = projectService;
    }

    @GetMapping("/{projectId}")
    public ResponseEntity<List<ErrorLogsResponse>> getErrorsByProject(@PathVariable Long projectId) {
        Users user = userService.getAuthenticated();
        Optional<Project> project = projectService.findProjectByIdAndUser(projectId, user);
        if (!project.isPresent()) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(Collections.emptyList());
        }
        Project project1 = project.get();
        List<ErrorLog> errors = errorService.getErrorsByProject(project1);
        return ResponseEntity.ok(ErrorLogsResponse.buildResponses(errors));
    }

    @PostMapping("/add/{projectId}")
    public Message addError(@PathVariable Long projectId, @RequestBody ErrorLog errorLog) {
        Users user = userService.getAuthenticated();
        Optional<Project> project = projectService.findProjectByIdAndUser(projectId, user);
        if (!project.isPresent()) {
            return new Message("Project not found or unauthorized");
        }

        errorLog.setUser(user);
        Project project1 = project.get();
        errorLog.setProject(project1);
        errorService.addError(errorLog);
        return new Message("Error log added successfully");
    }

    @DeleteMapping("/Delete/{id}")
    public String deleteErrorLogById(@PathVariable Long id) {
        Users user = userService.getAuthenticated();
        return errorService.deleteById(id, user);
    }

    @GetMapping("/error/{id}")
    public List<ErrorLogsResponse> findErrorLogByid(@PathVariable Long id) {
        Users user = userService.getAuthenticated();
        List<ErrorLog> error = errorService.findById(id, user);
        return ErrorLogsResponse.buildResponses(error);
    }
}