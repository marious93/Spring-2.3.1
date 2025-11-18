package org.example.dao;

import org.example.model.User;

import java.util.List;

public interface UserDao {
    public List<User> getUserList();

    public User findById(int id);

    public void saveUser(User user);

    public void updateUser(int id, User updatedUser);

    public void deleteUser(int id);
}
