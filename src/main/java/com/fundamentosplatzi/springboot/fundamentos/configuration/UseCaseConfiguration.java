package com.fundamentosplatzi.springboot.fundamentos.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fundamentosplatzi.springboot.fundamentos.service.UserService;
import com.fundamentosplatzi.springboot.fundamentos.usecase.CreateUser;
import com.fundamentosplatzi.springboot.fundamentos.usecase.CreateUserImplement;
import com.fundamentosplatzi.springboot.fundamentos.usecase.DeleteUser;
import com.fundamentosplatzi.springboot.fundamentos.usecase.DeleteUserImpl;
import com.fundamentosplatzi.springboot.fundamentos.usecase.GetUser;
import com.fundamentosplatzi.springboot.fundamentos.usecase.GetUserImplement;
import com.fundamentosplatzi.springboot.fundamentos.usecase.UpdateUser;
import com.fundamentosplatzi.springboot.fundamentos.usecase.UpdateUserImpl;

@Configuration
public class UseCaseConfiguration {
    
    @Bean
    GetUser getUser(UserService userService){
        return new GetUserImplement(userService);
    }

    @Bean
    CreateUser createUser(UserService userService){
        return new CreateUserImplement(userService);
    }

    @Bean
    DeleteUser deleteUser(UserService userService){
        return new DeleteUserImpl(userService);
    }

    @Bean
    UpdateUser updateUser(UserService userService){
        return new UpdateUserImpl(userService);
    }
}
