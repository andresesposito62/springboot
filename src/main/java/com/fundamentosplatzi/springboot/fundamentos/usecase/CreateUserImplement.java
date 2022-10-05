package com.fundamentosplatzi.springboot.fundamentos.usecase;

import com.fundamentosplatzi.springboot.fundamentos.entity.Users;
import com.fundamentosplatzi.springboot.fundamentos.service.UserService;

public class CreateUserImplement implements CreateUser{
    private UserService userService;

    public CreateUserImplement(UserService userService) {
        this.userService = userService;
    }

    @Override
    public Users save(Users user) {
        return userService.save(user);        
    }



}
