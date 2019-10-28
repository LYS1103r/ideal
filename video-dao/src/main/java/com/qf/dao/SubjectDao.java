package com.qf.dao;

import com.qf.entity.Subject;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SubjectDao {
    @Select("select * from subject")
    public List<Subject> getAll();


    public Subject getSubjectCourse(Integer id);


    public Subject thereAll(Integer id);

}
