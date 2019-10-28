package com.qf.controller;

import com.qf.entity.Course;
import com.qf.entity.QueryVo;
import com.qf.service.CourseService;
import com.qf.service.SubjectService;
import com.qf.videos.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Controller
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;
    @Autowired
    private SubjectService subjectService;

    @RequestMapping("/showCourseList")
    public String getAll(Model model, QueryVo queryVo){
        Page<Course> coursePage = courseService.getAllPage(queryVo);

        model.addAttribute("page",coursePage);

        return "behind/courseList";
    }

    @RequestMapping("/courseDel")
    public void courseDel(Integer id, HttpServletResponse response) throws IOException {
        courseService.courseDel(id);
        response.getWriter().print("success");
    }

    @RequestMapping("/addCourse")
    public String addSpeaker(Model model){
        model.addAttribute("subjectList",subjectService.getAll());
        return "behind/addCourse";
    }

    @RequestMapping("/edit")
    public String edit(Integer id,Model model){
        Course course = courseService.edit(id);
        model.addAttribute("subjectList",subjectService.getAll());
        model.addAttribute("course",course);
        return "behind/addCourse";
    }

    @RequestMapping("/saveOrUpdate")
    public String saveOrUpdate(Course course){
        if (course.getId()==null){
            courseService.save(course);
        }else{
            courseService.update(course);
        }
        return "redirect:showCourseList";
    }


    //--------------前台系统------------

    @RequestMapping("/course/{id}")
    public String course(@PathVariable(value = "id") Integer id, Model model){

       model.addAttribute("subject",subjectService.thereAll(id));
       //model.addAttribute("course",courseService.getById(id));
        model.addAttribute("subjectList",subjectService.getAll());

        System.out.println(subjectService.getSubjectCourse(id));

        return "before/course";
    }
}
