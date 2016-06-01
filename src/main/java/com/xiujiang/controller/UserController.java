package com.xiujiang.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xiujiang.pojo.RequestResult;
import com.xiujiang.pojo.UserInfo;
import com.xiujiang.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController
{
    @Autowired
    private UserService userService;
    
    @RequestMapping(method=RequestMethod.POST)
    public @ResponseBody RequestResult addUser(@RequestBody UserInfo userInfo)
    {
        boolean doesAddSuccess = userService.addUser(userInfo);
        RequestResult requestResult = new RequestResult();
        
        if(doesAddSuccess)
        {
            requestResult.setCode(10000);
            requestResult.setMessage("success");    
        }
        else
        {
            requestResult.setCode(20000);
            requestResult.setMessage("failure");
        }
        return requestResult;
    }
    
    
    @RequestMapping(value="/{name}",method=RequestMethod.GET)
    public @ResponseBody RequestResult getUser(@PathVariable("name") String userName)
    {
        RequestResult requestResult = new RequestResult();
        UserInfo user  = userService.getUserByName(userName);
        requestResult.setData(user);
        if(user == null)
        {
            requestResult.setCode(30000); 
            requestResult.setMessage("not found");
        }
        else 
        {
            requestResult.setCode(10000);
            requestResult.setMessage("success");    
        }
        return requestResult;
    }
    
    
    @RequestMapping(method=RequestMethod.PUT)
    public @ResponseBody RequestResult editUser(@RequestBody UserInfo userInfo)
    {
        UserInfo user  = userService.editUser(userInfo);
        RequestResult requestResult = new RequestResult();
        requestResult.setData(user);
        if(user == null)
        {
            requestResult.setCode(30000);
            requestResult.setMessage("not found");
        }
        else 
        {
            requestResult.setCode(10000);
            requestResult.setMessage("success");    
        }
        return requestResult;
    }
    
    @RequestMapping(value="/{name}",method=RequestMethod.DELETE)
    public @ResponseBody RequestResult delUser(@PathVariable("name") String userName)
    {
        boolean doesDelSuccess = userService.delUser(userName);
        RequestResult requestResult = new RequestResult();
        
        if(doesDelSuccess)
        {
            requestResult.setCode(10000);
            requestResult.setMessage("success");    
        }
        else
        {
            requestResult.setCode(20000);
            requestResult.setMessage("failure");
        }
        return requestResult;
    }
    
    
    @RequestMapping(method=RequestMethod.GET)
    public @ResponseBody RequestResult getUserList()
    {
        RequestResult requestResult = new RequestResult();
        requestResult.setCode(10000);
        requestResult.setMessage("success"); 
        requestResult.setData(userService.getAllUsers());
        return requestResult;
    }
}
