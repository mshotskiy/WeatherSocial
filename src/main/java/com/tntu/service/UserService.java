package com.tntu.service;

import com.tntu.entity.User;
import com.tntu.exceptions.CreateUserException;

public interface UserService {
    User findByUsername(String username);
    User createUser(User user) throws CreateUserException;
}
