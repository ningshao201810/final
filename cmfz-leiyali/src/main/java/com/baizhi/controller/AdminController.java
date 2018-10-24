package com.baizhi.controller;

import com.baizhi.entity.Admin;
import com.baizhi.entity.Menu;
import com.baizhi.service.AdminService;
import com.baizhi.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @Autowired
    private MenuService menuService;

    @RequestMapping("/ceshi")
    public String ceshi(){
        List<Menu> query = menuService.query();
        System.out.println("query:"+query);
        return "index";
    }
    @RequestMapping("/login")
    public String login(Admin admin, String code, Map map, HttpSession session){
        String code1= (String) session.getAttribute("code");
        System.out.println("admin:"+admin);
        if(code1.equalsIgnoreCase(code)){//
            Admin login = adminService.login(admin);
            if(login!=null){
                List<Menu> list=menuService.query();
                map.put("list",list);
                System.out.println("list:"+list);
                session.setAttribute("admin",login);
                return "main/main";
            }
        }else {
            session.setAttribute("msg","用户名或密码错误，请重新登录");
        }
        return "index";
    }
}
