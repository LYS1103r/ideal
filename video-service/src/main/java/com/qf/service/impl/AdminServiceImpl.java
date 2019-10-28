package com.qf.service.impl;

import com.qf.dao.AdminDao;
import com.qf.entity.Admin;
import com.qf.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
@Service("adminService")
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDao adminDao;

    @Override
    public List<Admin> getAll() {
        System.out.println("业务层：获取所有管理员。。。");
        return adminDao.getAll();
    }

    @Override
    public String login(Admin admin) {
        System.out.println("业务层：登录验证。。。");
        Integer num=adminDao.login(admin);
        if(num>0){
            return "success";
        }else{

            return "failure";
        }
    }
}
