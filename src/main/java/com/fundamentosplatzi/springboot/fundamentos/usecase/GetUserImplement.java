package com.fundamentosplatzi.springboot.fundamentos.usecase;

import java.util.List;

import com.fundamentosplatzi.springboot.fundamentos.entity.Users;
import com.fundamentosplatzi.springboot.fundamentos.service.UserService;

public class GetUserImplement  implements GetUser{

    private UserService userService;

    public GetUserImplement(UserService userService) {
        this.userService = userService;
    }

    @Override
    public List<Users> getAll() {
        return userService.getAllUsers();
    }
    
}
