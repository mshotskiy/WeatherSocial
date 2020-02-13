package com.tntu.service.impl;

import com.tntu.entity.Role;
import com.tntu.entity.User;
import com.tntu.exceptions.CreateUserException;
import com.tntu.repository.UserRepository;
import com.tntu.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {
    final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) throws CreateUserException {
        User userFromDb = findByUsername(user.getUsername());

        if (userFromDb != null) {
            throw new CreateUserException("User exist");
        }
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        userRepository.save(user);
        return user;
    }

    @Override
    public List<User> findAllUser() {
        return (List<User>) userRepository.findAll();
    }


    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Optional<User> findByUserId(long id) {
        return userRepository.findById(id);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }
}
