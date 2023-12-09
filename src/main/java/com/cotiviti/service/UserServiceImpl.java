package com.cotiviti.service;

import com.cotiviti.model.User;
import com.cotiviti.repository.UserRepositoryImpl;

import java.util.UUID;

public class UserServiceImpl implements UserService{

    UserRepositoryImpl userRepository;

    UserServiceImpl(UserRepositoryImpl userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(String firstName, String lastName, String email, String password, String repeatedPassword) {
        if(firstName == null || firstName.trim().isEmpty()){
            throw new IllegalArgumentException("firstname is empty");
        }
        boolean  created = userRepository.save(new User(UUID.randomUUID().toString(), firstName, lastName, email));
        if(!created){
            throw new UserIsNotCreated("Cannot create the user!");
        }
        return new User(UUID.randomUUID().toString(), firstName, lastName, email);
    }
}
