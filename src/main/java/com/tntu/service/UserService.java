package com.tntu.service;

import com.tntu.entity.User;
import com.tntu.exceptions.CreateUserException;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User findByUsername(String username);
    Optional<User> findByUserId(long id);
    User createUser(User user) throws CreateUserException;
    List<User> findAllUser();
}
