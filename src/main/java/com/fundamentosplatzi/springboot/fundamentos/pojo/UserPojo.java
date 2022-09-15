package com.fundamentosplatzi.springboot.fundamentos.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

//Para inyectar como dependencia, y que construya el pojo a partir de las propiedades
@ConstructorBinding

//con el prefijo "user" representamos el campo user del application.properties
@ConfigurationProperties(prefix = "user")

public class UserPojo {

    private String email;
    private String password;
    private int age;

    public UserPojo(String email, String password, int age) {
        this.email = email;
        this.password = password;
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    
}
