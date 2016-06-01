package com.xiujiang.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xiujiang.pojo.RequestResult;
import com.xiujiang.pojo.UserInfo;

@Controller
@RequestMapping("/user")
public class UserController
{
    public static Map<String,UserInfo> mapUserInfo = new HashMap<String,UserInfo>();
    
    @RequestMapping(method=RequestMethod.POST)
    public @ResponseBody RequestResult addUser(@RequestBody UserInfo userInfo)
    {
        mapUserInfo.put(userInfo.getName(),userInfo);
        RequestResult requestResult = new RequestResult();
        requestResult.setCode(10000);
        requestResult.setMessage("success");
        return requestResult;
    }
    
    
    @RequestMapping(value="/{name}",method=RequestMethod.GET)
    public @ResponseBody UserInfo getUser(@PathVariable("name") String userName)
    {
        return mapUserInfo.get(userName);
    }
    
    
    @RequestMapping(method=RequestMethod.PUT)
    public @ResponseBody RequestResult editUser(@RequestBody UserInfo userInfo)
    {
        mapUserInfo.put(userInfo.getName(),userInfo);
        RequestResult requestResult = new RequestResult();
        requestResult.setCode(10000);
        requestResult.setMessage("success");
        return requestResult;
    }
    
    @RequestMapping(value="/{name}",method=RequestMethod.DELETE)
    public @ResponseBody RequestResult editUser(@PathVariable("name") String userName)
    {
        mapUserInfo.remove(userName);
        RequestResult requestResult = new RequestResult();
        requestResult.setCode(10000);
        requestResult.setMessage("success");
        return requestResult;
    }
    
    
    @RequestMapping(method=RequestMethod.GET)
    public @ResponseBody List<UserInfo> getUserList()
    {
        List<UserInfo> listUserInfo = new ArrayList<UserInfo>();
        for(String name:mapUserInfo.keySet())
        {
            listUserInfo.add(mapUserInfo.get(name));
        }
        return listUserInfo;
    }
}
