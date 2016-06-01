package com.xiujiang.service.impl;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.xiujiang.pojo.UserInfo;
import com.xiujiang.service.OrderService;

public class OrderServiceImpl   implements OrderService
{

    @Autowired
    public RestTemplate restTemplate;
    @Override
    public UserInfo getOrderOwnerByName(String userName)
    {
        String uri = "http://localhost:8080/GreetingSpring/user/" + userName;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        
        ResponseEntity<UserInfo> response = restTemplate.exchange(uri, HttpMethod.GET, entity, UserInfo.class);
        
        return response.getBody();
    }

}
