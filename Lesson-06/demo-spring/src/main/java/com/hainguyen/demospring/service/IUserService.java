package com.hainguyen.demospring.service;

import com.hainguyen.demospring.model.User;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IUserService {
    List<User> findAll();

    void save(User user);

    User findById(Long id);

    void remove(Long id);

    List<User> searchByName(String username);
}
