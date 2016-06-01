package com.xiujiang.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.xiujiang.pojo.UserInfo;
import com.xiujiang.service.UserService;

@Service
public class UserServiceImpl implements UserService
{
    public static Map<String,UserInfo> mapUserInfo = new HashMap<String,UserInfo>();
   
    
    public UserInfo getUserByName(String name)
    {
       return mapUserInfo.get(name);
    }

    @Override
    public boolean addUser(UserInfo user)
    {
        mapUserInfo.put(user.getName(), user);
        return true;
    }

    @Override
    public UserInfo editUser(UserInfo user)
    {
        if(mapUserInfo.containsKey(user.getName()))
        {
            mapUserInfo.put(user.getName(), user);    
        }
        return mapUserInfo.get(user.getName());
    }

    @Override
    public boolean delUser(String name)
    {
        mapUserInfo.remove(name);
        return true;
    }

    @Override
    public List<UserInfo> getAllUsers()
    {
        List<UserInfo> listUserInfo = new ArrayList<UserInfo>();
        for(String name:mapUserInfo.keySet())
        {
            listUserInfo.add(mapUserInfo.get(name));
        }
        return listUserInfo;
    }
}
