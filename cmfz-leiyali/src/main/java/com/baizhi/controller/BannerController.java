package com.baizhi.controller;

import com.baizhi.entity.Banner;
import com.baizhi.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Date;
import java.util.Map;

@Controller
@RequestMapping("/banner")
public class BannerController {

    @Autowired
    private BannerService bannerService;

    @RequestMapping("/query")
    public @ResponseBody Map query(){
        System.out.println("进入banner方法");
        return bannerService.query();
    }

    @RequestMapping("/add")
    public @ResponseBody boolean add(MultipartFile img, Banner banner, HttpServletRequest request) throws Exception{
        banner.setOldname(img.getOriginalFilename());
        System.out.println("banner::::"+banner);
        banner.setCreateDate(new Date());
        String name=new Date().getTime()+"_"+img.getOriginalFilename();
        banner.setName(name);
        String path=request.getSession().getServletContext().getRealPath("/");
        banner.setUrl("img/on/"+name);
        //System.out.println("getName:"+img.getName());//获取页面的name的名字
        System.out.println("getOriginalFilename:"+img.getOriginalFilename());//获取文件的名字
        File file=new File(path+"img/on/"+name);
        img.transferTo(file);
        return bannerService.add(banner);
    }

    @RequestMapping("/delete")
    public @ResponseBody boolean delete(int id){
        return bannerService.delete(id);
    }

    @RequestMapping("/update")
    public @ResponseBody boolean update(Banner banner){
        return bannerService.update(banner);
    }

}
