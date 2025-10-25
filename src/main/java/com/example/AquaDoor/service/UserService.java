package com.example.AquaDoor.service;

import com.example.AquaDoor.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User createUser(User user);

    User getUserById(Long id);

    List<User> getAllUsers();

    User updateUser(Long id, User user);

    void deleteUserById(Long id);

    void deleteAllUsers();
}
