package com.xiujiang.service;



import java.util.List;

import com.xiujiang.pojo.UserInfo;


public interface UserService
{
    public UserInfo getUserByName(String name);
   
    public boolean addUser(UserInfo user);
    
    public UserInfo editUser(UserInfo user);
    
    public boolean delUser(String name);
    
    public List<UserInfo> getAllUsers();
}
