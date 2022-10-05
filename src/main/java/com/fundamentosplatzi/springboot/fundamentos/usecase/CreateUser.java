package com.fundamentosplatzi.springboot.fundamentos.usecase;

import com.fundamentosplatzi.springboot.fundamentos.entity.Users;
import com.fundamentosplatzi.springboot.fundamentos.service.UserService;

public interface CreateUser {
    public Users save(Users user);
}
