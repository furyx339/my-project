package com.example.myproject.service;

import com.example.myproject.model.ErrorLog;
import com.example.myproject.model.Project;
import com.example.myproject.model.Users;
import com.example.myproject.repository.MysqlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;


@Service
public class ErrorService {

    @Autowired
    MysqlRepository mysqlRepository;
    public List<ErrorLog> getErrorsByUser(Users user) {
       return mysqlRepository.findByUser(user);
    }

    public void addError(ErrorLog errorLog) {
        mysqlRepository.save(errorLog);
    }

    public List<ErrorLog> findById(Long id, Users user) {
        Optional<ErrorLog> errorLog = mysqlRepository.findByIdAndUser(id, user);
        return errorLog.map(Collections::singletonList).orElse(Collections.emptyList());
    }

    public String deleteById(Long id, Users user) {
        Optional<ErrorLog> errorLog = mysqlRepository.findByIdAndUser(id, user);
        if (errorLog.isPresent()) {
            mysqlRepository.delete(errorLog.get());
            return "Error deleted successfully";
        } else {
            return "Error not found or not authorized to delete";
        }
    }


    public List<ErrorLog> getErrorsByProject(Project project) {
        return mysqlRepository.findByProject(project);
    }
}
