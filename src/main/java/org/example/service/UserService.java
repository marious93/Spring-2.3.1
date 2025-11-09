package org.example.service;


import org.example.entity.User;

import java.util.List;

public interface UserService {
    public void addUser(User user);
    public void updateUser(User user);
    public void deleteUser(User user);
    public User findUserById(int id);
    public List<User> findAllUsers();
}