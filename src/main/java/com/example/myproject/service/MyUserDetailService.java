package com.example.myproject.service;

import com.example.myproject.model.Users;
import com.example.myproject.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            Users user = userRepo.findByUsername(username);
            if(user != null){
                var users = User.builder().username(user.getUsername())
                        .password(user.getPassword())
                        .build();
                System.out.println(users);
                return users;
            }
        throw new UsernameNotFoundException("User not found with username: " + username);
    }

}

