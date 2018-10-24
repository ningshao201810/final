package com.baizhi.service.impl;

import com.baizhi.dao.MenuDao;
import com.baizhi.entity.Menu;
import com.baizhi.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service("menuService")
public class MenuServiceImpl implements MenuService {

    @Autowired
    MenuDao menuDao;
    @Override
    public List<Menu> query() {
        List<Menu> list=menuDao.query();
        return list;
    }
}
