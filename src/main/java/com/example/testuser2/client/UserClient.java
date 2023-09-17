package com.example.testuser2.client;

import com.example.testuser2.dao.entity.UserEntity;
import jakarta.validation.constraints.AssertFalse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name="ms-client",url="http://localhost:8081/users/get")
public interface UserClient {
    @GetMapping()
    List<UserEntity> getUsers();
}
