package com.example.testuser2.Service.service;

import com.example.testuser2.dao.entity.UserEntity;
import com.example.testuser2.dao.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {


    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserEntity> getUsers(){
        return userRepository.findAll();
    }
}
