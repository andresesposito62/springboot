package com.fundamentosplatzi.springboot.fundamentos.usecase;

import java.util.Optional;

import com.fundamentosplatzi.springboot.fundamentos.entity.Users;
import com.fundamentosplatzi.springboot.fundamentos.service.UserService;

public class UpdateUserImpl implements UpdateUser{

    private UserService userService;    

    public UpdateUserImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public Users update(Users newUser, Long id) {
        return userService.update(newUser, id);        
    }
    
}
