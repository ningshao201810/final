package com.baizhi.dao;

import com.baizhi.entity.Banner;

import java.util.List;

public interface BannerDao {
    public List<Banner> query();

    int count();

    void insert(Banner banner);

    void delete(int id);

    void update(Banner banner);
}
