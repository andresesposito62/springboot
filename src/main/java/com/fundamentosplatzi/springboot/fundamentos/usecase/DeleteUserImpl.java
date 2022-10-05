package com.fundamentosplatzi.springboot.fundamentos.usecase;

import com.fundamentosplatzi.springboot.fundamentos.service.UserService;

public class DeleteUserImpl implements DeleteUser{

    private UserService userService;

    public DeleteUserImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void remove(Long id) {
        userService.delete(id);        
    }
    
}
