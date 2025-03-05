package com.example.myproject.repository;

import com.example.myproject.model.Project;
import com.example.myproject.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project,Long> {
    List<Project> findByUser(Users user);

    Project findByIdAndUser(Long id, Users username);

}
