package com.snipe.service.impl;

import com.snipe.dao.UserDao;
import com.snipe.entity.User;
import com.snipe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }

    @Override
    public User getById(Integer id) {
        return userDao.getById(id);
    }

    @Override
    public User getByAccountAndPassword(String account, String password) {
        return userDao.getByAccountAndPassword(account,password);
    }

    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    public  void update(User user) {
        userDao.update(user);
    }

    @Override
    public void deleteByStatus(Integer id, String status) {
        userDao.deleteByStatus(id,status);
    }

    @Override
    public void delete(Integer id) {
        userDao.delete(id);
    }

}
