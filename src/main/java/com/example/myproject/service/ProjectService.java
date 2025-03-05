package com.example.myproject.service;

import com.example.myproject.model.Project;
import com.example.myproject.model.Users;
import com.example.myproject.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private UserService userService;

    public String createProject(Project project, Users user) {
        project.setUser(user);
        projectRepository.save(project);
        return "project created successfully";
    }

    public List<Project> getProjectByUser(Users user){
        return projectRepository.findByUser(user);
    }

    public Optional<Project> findProjectByIdAndUser(Long projectId, Users user) {
        return Optional.ofNullable(projectRepository.findByIdAndUser(projectId, user));

    }

    public void deleteById(Long id, Users user) {
        Project project = projectRepository.findByIdAndUser(id, user);
        projectRepository.delete(project);
        }
}
