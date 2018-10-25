package com.baizhi.service.impl;

import com.baizhi.dao.BannerDao;
import com.baizhi.entity.Banner;
import com.baizhi.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("bannerService")
public class BannerServiceImpl implements BannerService {
    @Autowired
    private BannerDao bannerDao;
    @Override
    public Map query() {
        List<Banner> query = bannerDao.query();
        Map map=new HashMap();
        map.put("rows",query);
        int count=bannerDao.count();
        map.put("total",count);
        System.out.println("map"+map);
        return map;
    }

    @Override
    public boolean add(Banner banner) {
        try{
            bannerDao.insert(banner);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean delete(int id) {
        try{
            bannerDao.delete(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean update(Banner banner) {
        try{
            bannerDao.update(banner);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
