package com.example.myproject.repository;

import com.example.myproject.model.ErrorLog;
import com.example.myproject.model.Project;
import com.example.myproject.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MysqlRepository extends JpaRepository<ErrorLog,Long> {
    List<ErrorLog> findByUser(Users user);

    Optional<ErrorLog> findByIdAndUser(Long id, Users username);

    List<ErrorLog> findByProject(Project project);

}
