package com.qf.service;

import com.qf.entity.Admin;

import java.util.List;

public interface AdminService {
    public List<Admin> getAll();
    public String login(Admin admin);
}
