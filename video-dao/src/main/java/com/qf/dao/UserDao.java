package com.qf.dao;

import com.qf.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface UserDao {

    @Select("select count(*) from user where email=#{email} and password=#{password}")
    public Integer loginUser(User user);

    @Select("select * from user where email=#{email} and password=#{password}")
    public User getUserLogin(User user);

    @Select("select password from user where id=#{id}")
    public String getpassword(Integer  id);

    @Update("update user set `password`=#{password} where id=#{id}")
    public void updatePassword(User user);

    @Update("update user set nickName=#{nickName},sex=#{sex},birthday=#{birthday},address=#{address} where id=#{id}")
    public void updateUser(User user);

    @Select("select * from user where id=#{id}")
    public User getUpdateUser(Integer id);
    @Select("select * from user where email=#{email}")
    public User getUpdateUser1(String email);

    @Update("update user set imgUrl=#{imgUrl} where id=#{id}")
    public void updateUserImage(User user);
    @Update("update user set imgUrl=#{imgUrl} where email=#{email}")
    public void updateUserImage1(User user);

    @Select("select count(*) from user where email=#{email}")
    public Integer sendEmail(String email);

    @Update("update user set code=#{code} where email=#{email}")
    public void userCode(User user);

    @Select("select count(*) from user where email=#{email} and code=#{code}")
    public Integer validateEmailCode(User user);

    @Update("update user set password=#{password},code=#{code} where email=#{email}")
    public void resetPassword(User user);

    @Select("select count(*) from user where email=#{email}")
    public Integer validateEmail(String email);

    @Insert("insert into user(email,password) values(#{email},#{password})")
    public void insertUser(User user);

    @Select("select * from user where email=#{email} and password=#{password}")
    public User getRegUser(User user);
}
