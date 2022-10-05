package com.fundamentosplatzi.springboot.fundamentos.usecase;

import java.util.Optional;

import com.fundamentosplatzi.springboot.fundamentos.entity.Users;
import com.fundamentosplatzi.springboot.fundamentos.service.UserService;

public interface UpdateUser {
    public Users update(Users newUser, Long id);
}
