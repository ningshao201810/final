package com.baizhi.service.impl;

import com.baizhi.dao.AlbumDao;
import com.baizhi.entity.Album;
import com.baizhi.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("albumService")
public class AlbumServiceImpl implements AlbumService {

    @Autowired
    private AlbumDao albumDao;
    @Override
    public List<Album> query() {
        return albumDao.query();
    }

    @Override
    public List<Album> getAlbum() {
        return albumDao.getAlbum();
    }
}
