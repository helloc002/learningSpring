package com.xiujiang.pojo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class RequestResult
{
    private int code;
    private String message;
    
    
    public int getCode()
    {
        return code;
    }
    public void setCode(int code)
    {
        this.code = code;
    }
    public String getMessage()
    {
        return message;
    }
    public void setMessage(String message)
    {
        this.message = message;
    }
    
    
}
