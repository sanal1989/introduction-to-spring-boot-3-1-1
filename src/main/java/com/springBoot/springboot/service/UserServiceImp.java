package com.springBoot.springboot.service;

import com.springBoot.springboot.dao.UserDao;
import com.springBoot.springboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

   @Autowired
   private UserDao userDao;

   @Transactional
   @Override
   public void add(User user) {
      userDao.add(user);
   }

   @Override
   public User getById(long id) {
      return userDao.getById(id);
   }

   @Transactional
   @Override
   public void updateUser(User user) {
      userDao.updateUser(user);
   }

   @Transactional
   @Override
   public void deleteById(long id) {
      userDao.deleteById(id);
   }

   @Override
   public List<User> getUsers() {
      return userDao.getUsers();
   }

}
