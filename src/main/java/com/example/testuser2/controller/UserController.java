//package com.example.testuser2.controller;
//
//import com.example.testuser2.Service.service.UserService;
//import com.example.testuser2.dao.entity.UserEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/users")
//public class UserController {
//    private final UserService userService;
//
//    public UserController(UserService userService) {
//        this.userService = userService;
//    }
//    //    @PreAuthorize("hasRole('Admin')")
//    @GetMapping("/get")
//    public List<UserEntity> getUsers(){
//        return userService.getUsers();
//    }
//}
