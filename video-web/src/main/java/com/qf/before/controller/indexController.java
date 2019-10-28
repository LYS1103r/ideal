package com.qf.before.controller;


import com.qf.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/index")
public class indexController {

    @Autowired
    private SubjectService subjectService;

    @RequestMapping("/login")
    public String login(Model model){
        model.addAttribute("subjectList",subjectService.getAll());
        System.out.println("进入方法体login");
        return "before/index";
    }

    @RequestMapping("/choose")
    public String choose(Model model, HttpServletRequest request){
        request.getSession().removeAttribute("userAccount");
        model.addAttribute("subjectList",subjectService.getAll());
        return "redirect:http://localhost:8080/video_web_war/index.jsp";
    }


    @RequestMapping("/user/showMyProfile")
    public String showMyProfile(Model model){
        model.addAttribute("subjectList",subjectService.getAll());
        return "before/my_profile";
    }



    @RequestMapping("/change_avatar")
    public String change_avatar(){
        return "before/change_avatar";
    }

    @RequestMapping("/change_profile")
    public String change_profile(){
        return "before/change_profile";
    }

    @RequestMapping("/course")
    public String course(){
        return "before/course";
    }

    @RequestMapping("/forget_password")
    public String forget_password(){
        return "before/forget_password";
    }

    @RequestMapping("/my_profile")
    public String my_profile(){
        return "before/my_profile";
    }

    @RequestMapping("/password_safe")
    public String password_safe(){
        return "before/password_safe";
    }

    @RequestMapping("/reset_password")
    public String reset_password(){
        return "before/reset_password";
    }

    @RequestMapping("/section")
    public String section(){
        return "before/section";
    }

}
