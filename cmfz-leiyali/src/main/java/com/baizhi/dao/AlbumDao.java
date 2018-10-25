package com.baizhi.dao;

import com.baizhi.entity.Album;

import java.util.List;

public interface AlbumDao {
    List<Album> query();

    List<Album> getAlbum();
}
