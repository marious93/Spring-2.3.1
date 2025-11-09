package org.example.dao;

import org.example.entity.User;

import java.util.List;

public interface UserDao {

    public void addUser(User user);
    public void updateUser(User user);
    public void deleteUser(User user);
    public User findUserById(int id);
    public List<User> findAllUsers();

}
