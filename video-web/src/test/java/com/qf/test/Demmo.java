package com.qf.test;

import com.qf.controller.AdminController;
import com.qf.entity.Admin;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class Demmo {
    @Autowired
    private AdminController adminController;

    @Test
    public void test(){
        Admin admin=new Admin();
        admin.setUsername("laoyan");
        admin.setPassword("123456");
        //adminController.login(admin);
    }

}
