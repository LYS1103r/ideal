package com.qf.service;

import com.qf.entity.Course;
import com.qf.entity.QueryVo;
import com.qf.videos.utils.Page;

import java.util.HashMap;
import java.util.List;

public interface CourseService {
    public List<Course> getAll();

    public Page<Course> getAllPage(QueryVo queryVo);

    public void courseDel(Integer id);

    public Course edit(Integer id);

    public void save(Course course);

    public void update(Course course);

    public List<Course> course(Integer id);


    public Course getById(Integer id);

    public Course getCorV(HashMap<String,Integer> map);
}
