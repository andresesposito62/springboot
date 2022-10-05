package com.fundamentosplatzi.springboot.fundamentos.usecase;

import java.util.List;

import com.fundamentosplatzi.springboot.fundamentos.entity.Users;

public interface GetUser {
    List<Users> getAll();
}
