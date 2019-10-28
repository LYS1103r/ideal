package com.qf.service;

import com.qf.entity.User;

public interface UserService {
    public String loginUser(User user);

    public User getUserLogin(User user);

    public String getpassword(Integer  id);

    public void updatePassword(User user);

    public void updateUser(User user);

    public User getUpdateUser(Integer id);
    public User getUpdateUser1(String email);

    public void updateUserImage(User user);
    public void updateUserImage1(User user);

    public Integer sendEmail(String email);

    public void userCode(User user);

    public Integer validateEmailCode(User user);

    public void resetPassword(User user);

    public Integer validateEmail(String email);

    public void insertUser(User user);

    public User getRegUser(User user);
}
