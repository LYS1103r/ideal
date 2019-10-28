package com.qf.service;

import com.qf.entity.Subject;

import java.util.List;

public interface SubjectService {
    public List<Subject> getAll();

    public Subject getSubjectCourse(Integer id);

    public Subject thereAll(Integer id);
}
