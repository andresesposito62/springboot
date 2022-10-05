package com.fundamentosplatzi.springboot.fundamentos.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fundamentosplatzi.springboot.fundamentos.entity.Users;
import com.fundamentosplatzi.springboot.fundamentos.usecase.GetUser;


@RestController
@RequestMapping("/api/users")
public class UserRestController {

    private GetUser getUser;

    public UserRestController(GetUser getUser) {
        this.getUser = getUser;
    }

    @GetMapping("")
    List<Users> get(){
        return getUser.getAll();
    }
}
