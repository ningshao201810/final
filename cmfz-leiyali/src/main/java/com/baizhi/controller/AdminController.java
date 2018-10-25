package com.baizhi.controller;

import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @RequestMapping("/ceshi")
    public String ceshi(){
        System.out.println("ceshi:");
        return "index";
    }
    @RequestMapping("/login")
    public String login(Admin admin, String code, Map map, HttpSession session){
        String code1= (String) session.getAttribute("code");
        System.out.println("admin:"+admin);
        if(code1.equalsIgnoreCase(code)){//
            Admin login = adminService.login(admin);
            if(login!=null){
                session.setAttribute("admin",login);
                return "main/main";
            }
        }else {
            session.setAttribute("msg","用户名或密码错误，请重新登录");
        }
        return "index";
    }
}
