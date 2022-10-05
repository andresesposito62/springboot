package com.fundamentosplatzi.springboot.fundamentos.controller;

import java.net.URI;
import java.net.http.HttpHeaders;
import java.util.List;

import javax.persistence.ManyToOne;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fundamentosplatzi.springboot.fundamentos.entity.Users;
import com.fundamentosplatzi.springboot.fundamentos.usecase.CreateUser;
import com.fundamentosplatzi.springboot.fundamentos.usecase.DeleteUser;
import com.fundamentosplatzi.springboot.fundamentos.usecase.GetUser;
import com.fundamentosplatzi.springboot.fundamentos.usecase.UpdateUser;


@RestController
@RequestMapping("/api/users")
public class UserRestController {

    private GetUser getUser;
    private CreateUser createUser;
    private DeleteUser deleteUser;
    private UpdateUser updateUser;

    public UserRestController(
        GetUser getUser,
        CreateUser createUser,
        DeleteUser deleteUser,
        UpdateUser updateUser
        ) {

        this.getUser = getUser;
        this.createUser = createUser;
        this.deleteUser = deleteUser;
        this.updateUser = updateUser;
    }

    @GetMapping("")
    List<Users> get(){
        return getUser.getAll();
    }


    @PostMapping("")
    ResponseEntity<Users> newUser(@RequestBody Users newUsers){
        return new ResponseEntity<Users>(createUser.save(newUsers), HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    ResponseEntity deleteUser(@PathVariable Long id){
        deleteUser.remove(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("{id}")
    ResponseEntity<Users> replaceUser(@RequestBody Users newUser, @PathVariable Long id){
        return new  ResponseEntity<>(updateUser.update(newUser, id), HttpStatus.OK);
    }


}
