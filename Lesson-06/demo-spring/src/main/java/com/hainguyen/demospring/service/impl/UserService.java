package com.hainguyen.demospring.service.impl;

import com.hainguyen.demospring.model.User;
import com.hainguyen.demospring.repository.IUserRepository;
import com.hainguyen.demospring.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {
    @Autowired
    IUserRepository userRepository;
    @Override
    public List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public User findById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("not id"));
        return user;
    }

    @Override
    public void remove(Long id) {
        User user =findById(id);
        if(user != null) {
            userRepository.delete(user);
        }
    }
}
