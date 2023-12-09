package com.cotiviti.service;

public class UserIsNotCreated extends RuntimeException {
    public UserIsNotCreated(String s) {
        super(s);
    }
}
