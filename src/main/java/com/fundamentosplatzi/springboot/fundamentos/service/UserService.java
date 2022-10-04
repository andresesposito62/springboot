package com.fundamentosplatzi.springboot.fundamentos.service;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.fundamentosplatzi.springboot.fundamentos.entity.Users;
import com.fundamentosplatzi.springboot.fundamentos.repository.UserRepository;

@Service
public class UserService {
    private final Log LOG = LogFactory.getLog(UserService.class);
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public void saveTransactional(List<Users> users){
        users.stream()
            .peek(user -> LOG.info("Usuario insertado. " + user))
            .forEach(userRepository::save);
    }

    public List<Users> getAllUsers(){
        return userRepository.findAll();
    }
    
}
