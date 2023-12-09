package com.cotiviti.service;

import com.cotiviti.model.User;

public interface UserService {
    User createUser(String firstName, String lastName, String email, String password, String repeatedPassword);
}
