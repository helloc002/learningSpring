package com.xiujiang.service;

import com.xiujiang.pojo.UserInfo;

public interface OrderService
{
    public UserInfo getOrderOwnerByName(String userName);
}
