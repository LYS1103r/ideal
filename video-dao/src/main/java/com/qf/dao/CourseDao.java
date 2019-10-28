package com.qf.dao;

import com.qf.entity.Course;
import com.qf.entity.QueryVo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.HashMap;
import java.util.List;

public interface CourseDao {
    @Select("select * from course")
    public List<Course> getAll();

    public List<Course> getAllPage(QueryVo queryVo);

    @Select("select count(1) from course")
    public Integer getCount();

    @Delete("delete from course where id=#{id}")
    public void courseDel(Integer id);

    @Select("select * from course where id=#{id}")
    public Course edit(Integer id);

    @Insert("insert into course(course_title,course_desc,subject_id) values(#{course_title},#{course_desc},#{subject_id})")
    public void save(Course course);

    @Update("update course set course_title=#{course_title},course_desc=#{course_desc},subject_id=#{subject_id} where id=#{id}")
    public void update(Course course);

//-----------客户端系统-------------
    @Select("select * from course where subject_id=#{id}")
    public List<Course> course(Integer id);

    @Select("select * from course where id=#{id}")
    public Course getById(Integer id);

    public Course getCorV(HashMap<String,Integer> map);
}
