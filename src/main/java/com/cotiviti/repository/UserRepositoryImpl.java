package com.cotiviti.repository;

import com.cotiviti.model.User;

import java.util.HashMap;
import java.util.Map;

public class UserRepositoryImpl implements UserRepository{
    Map<String, User> users = new HashMap<>();
    @Override
    public boolean save(User user) {
        boolean isCreated = false;
        if(!users.containsKey(user.getUserId())){
            users.put(user.getUserId(), user);
            return true;
        }
        return false;
    }
}
