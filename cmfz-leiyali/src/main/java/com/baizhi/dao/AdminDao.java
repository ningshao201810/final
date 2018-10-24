package com.baizhi.dao;

import com.baizhi.entity.Admin;

import java.util.List;

public interface AdminDao {
    Admin selectOne(Admin admin);
    /*public List<Admin> query();*/
}
