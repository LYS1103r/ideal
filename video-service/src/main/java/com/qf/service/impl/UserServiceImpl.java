package com.qf.service.impl;

import com.qf.dao.UserDao;
import com.qf.entity.User;
import com.qf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public String loginUser(User user) {
        Integer integer = userDao.loginUser(user);
        if (integer>0){
            return "success";
        }else{
            return "failure";
        }
    }

    @Override
    public User getUserLogin(User user) {
        return userDao.getUserLogin(user);
    }

    @Override
    public String getpassword(Integer id) {
        return userDao.getpassword(id);
    }

    @Override
    public void updatePassword(User user) {
        //System.out.println("业务层："+id+" "+password);
        userDao.updatePassword(user);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public User getUpdateUser(Integer id) {
        return userDao.getUpdateUser(id);
    }
    @Override
    public User getUpdateUser1(String email) {
        return userDao.getUpdateUser1(email);
    }

    @Override
    public void updateUserImage(User user) {
        userDao.updateUserImage(user);
    }
    @Override
    public void updateUserImage1(User user) {
        userDao.updateUserImage1(user);
    }

    @Override
    public Integer sendEmail(String email) {
        return userDao.sendEmail(email);
    }

    @Override
    public void userCode(User user) {
        userDao.userCode(user);
    }

    @Override
    public Integer validateEmailCode(User user) {
        return userDao.validateEmailCode(user);
    }

    @Override
    public void resetPassword(User user) {
        userDao.resetPassword(user);
    }

    @Override
    public Integer validateEmail(String email) {
        return userDao.validateEmail(email);
    }

    @Override
    public void insertUser(User user) {
        userDao.insertUser(user);
    }

    @Override
    public User getRegUser(User user) {
        return userDao.getRegUser(user);
    }
}
