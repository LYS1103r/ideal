package com.qf.controller;

import com.qf.entity.Admin;
import com.qf.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    //private HttpServletResponse response;

    @RequestMapping("/showAdmin")
    public String showAdmin(Model model){
        System.out.println("表现层：获取所有管理员。。。");
        List<Admin> list=adminService.getAll();
        model.addAttribute("list",list);
        return "behind/login";
    }

    @RequestMapping("/login")
    public void login(Admin admin, HttpServletResponse response, HttpServletRequest request,Model model){

        System.out.println(admin);
        System.out.println("表现层：登录验证。。。");
        String data = adminService.login(admin);

        System.out.println(data);

        try {
            String names=admin.getUsername();
            request.getSession().setAttribute("userName",names);
            //model.addAttribute("sessionScope",admin.getUsername());
            //request.setAttribute("sessionScope",admin);
            response.getWriter().print(data);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @RequestMapping("/exit")
    public String exit(HttpServletRequest request){
        request.getSession().removeAttribute("userName");
        return "redirect:showAdmin";
    }


}
