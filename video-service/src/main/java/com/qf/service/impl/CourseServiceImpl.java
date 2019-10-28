package com.qf.service.impl;

import com.qf.dao.CourseDao;
import com.qf.dao.VideoDao;
import com.qf.entity.Course;
import com.qf.entity.QueryVo;
import com.qf.service.CourseService;
import com.qf.videos.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
@Service("courseService")
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseDao courseDao;

    @Autowired
    private VideoDao videoDao;

    @Override
    public List<Course> getAll() {
        return courseDao.getAll();
    }

    @Override
    public Page<Course> getAllPage(QueryVo queryVo) {
        // 设置查询条件,从哪一条数据开始查
        queryVo.setStart((queryVo.getPage() - 1) * queryVo.getRows());

        // 查询数据结果集
        List<Course> list = courseDao.getAllPage(queryVo);

        // 查询到的数据总条数
        Integer total = courseDao.getCount();

        // 封装返回的page对象
        Page<Course> coursePage = new Page<Course>();
        //查询数据
        coursePage.setRows(list);
        //当前页
        coursePage.setPage(queryVo.getPage());
        //每页数据
        coursePage.setSize(queryVo.getRows());
        //总记录数
        coursePage.setTotal(total);

        return coursePage;
    }

    @Override
    public void courseDel(Integer id) {
        courseDao.courseDel(id);
    }

    @Override
    public Course edit(Integer id) {
        return courseDao.edit(id);
    }

    @Override
    public void save(Course course) {
        courseDao.save(course);
    }

    @Override
    public void update(Course course) {
        courseDao.update(course);
    }

    @Override
    public List<Course> course(Integer id) {
        return courseDao.course(id);
    }

    @Override
    public Course getById(Integer id) {
        Course course = courseDao.getById(id);
        course.setVideoList(videoDao.getByCourseId(id));
        return course;
    }

    @Override
    public Course getCorV(HashMap<String, Integer> map) {
        return courseDao.getCorV(map);
    }
}
