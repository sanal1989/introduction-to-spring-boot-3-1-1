package com.springBoot.springboot.service;



import com.springBoot.springboot.model.User;

import java.util.List;

public interface UserService {
    void add(User user);
    User getById(long id);
    void updateUser(User user);
    void deleteById(long id);
    List<User> getUsers();
}
