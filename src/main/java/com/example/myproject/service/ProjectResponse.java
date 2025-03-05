package com.example.myproject.service;

import com.example.myproject.model.Project;
import com.example.myproject.model.Users;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Builder
public class ProjectResponse {
    private Long id;
    private String name;
    private Users user;

    public static ProjectResponse buildResponse(Project project){
        ProjectResponse projectResponse = new ProjectResponse();
        projectResponse.id = project.getId();
        projectResponse.name = project.getName();
        projectResponse.user = project.getUser();

        return projectResponse;
    }

    public static List<ProjectResponse> buildResponses(List<Project> projects){
        List<ProjectResponse> responses = new ArrayList<>();
        for (Project project: projects){
            responses.add(buildResponse(project));
        }
        return responses;
    }

    public ProjectResponse() {
    }

    public ProjectResponse(Long id, String name, Users user) {
        this.id = id;
        this.name = name;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "ProjectResponse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", user=" + user +
                '}';
    }
}
