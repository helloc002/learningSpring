package com.xiujiang.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.xiujiang.pojo.UserInfo;

@Service
public class UserService
{
    @Autowired
    public RestTemplate restTemplate;
    
    public UserInfo getUserByName(String name)
    {
       String uri = "http://localhost:8080/GreetingSpring/user/" + name;
       HttpHeaders headers = new HttpHeaders();
       headers.setContentType(MediaType.APPLICATION_JSON);
       headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
       
       HttpEntity<String> entity = new HttpEntity<String>(headers);
       
       ResponseEntity<UserInfo> response = restTemplate.exchange(uri, HttpMethod.GET, entity, UserInfo.class);
       
       return response.getBody();
    }
}
