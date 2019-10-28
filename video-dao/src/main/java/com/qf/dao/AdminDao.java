package com.qf.dao;

import com.qf.entity.Admin;

import java.util.List;

public interface AdminDao {
    public List<Admin> getAll();

    public Integer login(Admin admin);
}
