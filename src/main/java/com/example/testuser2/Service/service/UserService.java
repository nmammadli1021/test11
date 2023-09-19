package com.example.testuser2.Service.service;

import com.example.testuser2.client.UserClient;
import com.example.testuser2.dao.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserClient userClient;
    public List<UserEntity> getUsers(){
        return userClient.getUsers();
    }
}
