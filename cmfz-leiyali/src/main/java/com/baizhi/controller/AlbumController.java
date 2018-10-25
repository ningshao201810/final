package com.baizhi.controller;

import com.baizhi.entity.Album;
import com.baizhi.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/album")
public class AlbumController {
    @Autowired
    private AlbumService albumService;

    @RequestMapping("/query")
    public List<Album> query(){
        System.out.println("Album:");
        System.out.println(albumService.query());
        return albumService.query();
    }

    @RequestMapping("/getAlbum")
    public List<Album> getAlbum(){
        System.out.println(albumService.query());
        return albumService.getAlbum();
    }

    /*@RequestMapping("/add")
    public boolean add(MultipartFile img,Album album, HttpServletRequest request){
        String realPath = request.getSession().getServletContext().getRealPath("/");

        return albumService.add();
    }*/
}
