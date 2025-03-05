package com.example.myproject.controller;

import com.example.myproject.model.Project;
import com.example.myproject.model.ProjectDTO;
import com.example.myproject.model.Users;
import com.example.myproject.repository.ProjectRepository;
import com.example.myproject.service.ProjectResponse;
import com.example.myproject.service.ProjectService;
import com.example.myproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/projects")
@Service
public class ProjectController {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private ProjectService projectService;

    @PostMapping
    public ResponseEntity<String> createProject(@RequestBody Project project){
        Users user = userService.getAuthenticated();
        return ResponseEntity.ok(projectService.createProject(project, user));
    }

    @GetMapping
    public List<ProjectDTO> getUserProjects(){
        Users user = userService.getAuthenticated();
        return projectService.getProjectByUser(user)
                .stream()
                .map(ProjectDTO::new)
                .collect(Collectors.toList());
    }

    @DeleteMapping("/delete/{projectId}")
    public void deleteProjectById(@PathVariable Long projectId){
        Users user = userService.getAuthenticated();
        projectService.deleteById(projectId, user);
    }
}
