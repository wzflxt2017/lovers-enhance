package com.lovers.common.base.controller;


import com.lovers.common.base.dto.common.Result;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@Data
public class BaseController {
    @Autowired
    protected HttpSession session;

    @Autowired
    protected HttpServletRequest request;

    @Autowired
    protected HttpServletResponse response;

    protected Result result=new Result();

    protected Map<String,Object> reqData=new HashMap<>();


    public String getParam(String key){
        return request.getParameter(key);
    }

    public String getRequestAttr(String key){
        return request.getAttribute(key)!=null?request.getAttribute(key).toString():null;
    }

    public Object getRequestObjectAttr(String key){
        return request.getAttribute(key);
    }

    public void setRequestAttr(String key,Object value){
        request.setAttribute(key,value);
    }



    public Object getSessionObjectAttr(String key){
        return session.getAttribute(key);
    }

    public String getSessionAttr(String key){
        return session.getAttribute(key)!=null?session.getAttribute(key).toString():null;
    }

    public void setSessionAttr(String key,Object value){
        session.setAttribute(key,value);
    }

}
