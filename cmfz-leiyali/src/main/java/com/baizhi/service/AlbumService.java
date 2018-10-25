package com.baizhi.service;

import com.baizhi.entity.Album;

import java.util.List;

public interface AlbumService {
    List<Album> query();

    List<Album> getAlbum();
}
