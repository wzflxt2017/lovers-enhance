package com.lovers.common.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lovers.common.base.constants.CommonConstants;
import com.lovers.common.base.controller.CommonController;
import com.lovers.common.domain.SysUser;
import com.lovers.common.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Calendar;

@Controller
@RequestMapping("/login")
public class LoginController extends CommonController {

    @Reference
    public LoginService loginService;

    @RequestMapping("/toLogin")
    public String toLogin(){
        return "java/login/login";
    }


    @ResponseBody
    @RequestMapping("/login")
    public Object login(){
        String userAccount = getParam("userAccount");
        String password = getParam("password");

        String md5DigestAsHex = DigestUtils.md5DigestAsHex(password.getBytes());
        SysUser sysUser = loginService.findByAccount(userAccount);
        if(sysUser.getPassword().equals(md5DigestAsHex)){
            session.setAttribute(CommonConstants.SESSION_USER,sysUser);
            session.setAttribute(CommonConstants.IS_LOGIN,true);
            result.setSuccess(true);
            result.setMessage("登录成功！");
        }else{
            result.setSuccess(false);
            result.setMessage("密码错误，登录失败！");
        }
        return result;
    }


    @RequestMapping("/toRegister")
    public String toRegister(){
        return "java/login/register";
    }

    @ResponseBody
    @RequestMapping("/register")
    public Object register(){
        String userAccount = getParam("userAccount");
        String password = getParam("password");
        String userName = getParam("userName");
        String md5DigestAsHex = DigestUtils.md5DigestAsHex(password.getBytes());
        SysUser sysUser = new SysUser();
        sysUser.setUserName(userName);
        sysUser.setUserAccount(userAccount);
        sysUser.setPassword(md5DigestAsHex);
        sysUser.setCreateTime(Calendar.getInstance().getTime());
        int i = loginService.addOne(sysUser);
        if(i==1){
            result.setSuccess(true);
            result.setMessage("注册成功！");
        }else{
            result.setSuccess(false);
            result.setMessage("发生未知错误，注册失败！");
        }
        return result;
    }
}
