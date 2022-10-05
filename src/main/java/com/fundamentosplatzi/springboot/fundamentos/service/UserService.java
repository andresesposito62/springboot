package com.fundamentosplatzi.springboot.fundamentos.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.catalina.User;
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

    public Users save(Users newUser){
        return userRepository.save(newUser);
    }

    public void delete(Long id){
        userRepository.delete(new Users(id));
    }
    
    public Users update(Users newUser, Long id){
        return userRepository.findById(id)
                .map(
                    user ->{
                        user.setEmail(newUser.getEmail());
                        user.setName(newUser.getName());
                        user.setBirthDate(newUser.getBirthDate());
                        return userRepository.save(user);
                    }
                ).get();
    }
}
