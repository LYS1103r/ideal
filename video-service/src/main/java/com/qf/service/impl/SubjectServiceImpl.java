package com.qf.service.impl;

import com.qf.dao.CourseDao;
import com.qf.dao.SubjectDao;
import com.qf.entity.Subject;
import com.qf.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectDao subjectDao;
    @Autowired
    private CourseDao courseDao;

    @Override
    public List<Subject> getAll() {
        return subjectDao.getAll();
    }

    @Override
    public Subject getSubjectCourse(Integer id) {
        Subject subject = subjectDao.getSubjectCourse(id);
        subject.setCourseList(courseDao.course(id));
        return subject;
    }

    @Override
    public Subject thereAll(Integer id) {
        return subjectDao.thereAll(id);
    }
}
