package com.baizhi.dao;

import com.baizhi.entity.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MenuDao {
    public List<Menu> query();
}
