package com.xiujiang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xiujiang.pojo.UserInfo;
import com.xiujiang.service.UserService;

@Controller
@RequestMapping("/order")
public class OrderController
{
    @Autowired
    public UserService userService;
    
    @RequestMapping("/{name}")
    public @ResponseBody String getUserOrder(@PathVariable("name") String userName)
    {
        UserInfo user = userService.getUserByName(userName);
        
        return user.getName().concat(" has bought nothing.");
    }
}
