package com.baizhi.controller;

import com.baizhi.entity.Chapter;
import com.baizhi.service.ChapterService;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

@RestController
@RequestMapping("/chapter")
public class ChapterController {
    @Autowired
    private ChapterService chapterService;

    @RequestMapping("/add")
    public boolean add(MultipartFile audio,int alId ,HttpServletRequest request) throws Exception{
        String newName=new Date().getTime()+"."+ FilenameUtils.getExtension(audio.getOriginalFilename());
        long size = audio.getSize();
        //long length =((File) audio).getTotalSpace();
        String pretty_name=audio.getOriginalFilename().substring(0,audio.getOriginalFilename().lastIndexOf("."));
        Chapter chapter=new Chapter(UUID.randomUUID().toString(),pretty_name,"audio/"+newName,size,size,alId,newName);
        System.out.println("chapter:"+chapter);
        String path=request.getSession().getServletContext().getRealPath("/");
        File file=new File(path+"/audio/"+newName);
        audio.transferTo(file);
        return chapterService.add(chapter);
    }

    @RequestMapping("/download")
    public ResponseEntity<byte[]> download(HttpServletRequest request,String url) throws IOException {
        String path = request.getSession().getServletContext().getRealPath("/");
        System.out.println("path:"+path);
        File file=new File(path+"/"+url);
        HttpHeaders headers=new HttpHeaders();
        headers.setContentDispositionFormData("attachment",url);
        //headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity<>(FileUtils.readFileToByteArray(file),headers, HttpStatus.CREATED);
    }
}
