package com.kj.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kj.entity.User;
import com.kj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

/**
 * 小哥
 * 控制器
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/","/users"})
    public String findByPage(@RequestParam(required = false) Integer pageNum,@RequestParam(required = false) Integer pageSize , Model model){
        if(pageNum==null){
            pageNum = 1;
        }
        if(pageSize==null){
            pageSize = 2;
        }
        PageInfo<User> pageInfo = userService.findByPage(pageNum, pageSize);
        model.addAttribute("pageInfo",pageInfo);
        //跳转解析页面  /list.jsp
        return "list";
    }

    @RequestMapping("/del")
    public String del(Long id){
        int i = userService.delUser(id);
        //删除成功之后查询所有用户信息
        return "redirect:/users";
    }

    @RequestMapping("/edit")
    public String edit(Long id,Model model){
        //修改
        if(id!=null){
            User user = userService.findById(id);
            model.addAttribute("user",user);
        }
        return "edit";
    }

    @RequestMapping("/addUser")
    public String addUser(User user){
        int i = userService.addUser(user);
        return "redirect:/users";
    }

    @RequestMapping("/updateUser")
    public String updateUser(User user){
        int i = userService.updateUser(user);
        return "redirect:/users";
    }

    @RequestMapping("/findByCondition")
    public String findByCondition(String name,Model model){
        PageHelper.startPage(1,2);
        List<User> users = userService.findByCondition(name);
        PageInfo<User> pageInfo = new PageInfo<>(users);
        model.addAttribute("pageInfo",pageInfo);
        //跳转解析页面  /list.jsp
        return "list";
    }
}
