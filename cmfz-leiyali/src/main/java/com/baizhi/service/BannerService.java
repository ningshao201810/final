package com.baizhi.service;

import com.baizhi.entity.Banner;

import java.util.Map;

public interface BannerService {
    public Map query();

    boolean add(Banner banner);

    boolean delete(int id);

    boolean update(Banner banner);
}
