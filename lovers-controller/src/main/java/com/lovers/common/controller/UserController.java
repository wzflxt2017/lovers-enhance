package com.lovers.common.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lovers.common.base.constants.CommonConstants;
import com.lovers.common.base.controller.CommonController;
import com.lovers.common.domain.SysFile;
import com.lovers.common.domain.SysUser;
import com.lovers.common.domain.UserMessage;
import com.lovers.common.service.SysFileService;
import com.lovers.common.service.UserService;
import com.lovers.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: wangzefeng
 * @Date: 2019-10-24 10:20
 * @Description:
 */
@Controller
@RequestMapping("/user/center")
public class UserController extends CommonController {


    @Reference
    private UserService userService;

    @Reference
    private SysFileService sysFileService;

    @RequestMapping("userCenter")
    public String userCenter(){
        SysUser sysUser = getSysUser();
        reqData.put("sysUser",sysUser);
//        setRequestAttr("sysUser",sysUser);
        return "java/user/userCenter";
    }


    @ResponseBody
    @RequestMapping("updateUser")
    public Object updateUser(SysUser sysUser){
        userService.updateUser(sysUser);
        SysUser newUser = userService.findById(sysUser.getUserId());
        session.setAttribute(CommonConstants.SESSION_USER,newUser);
        result.setSuccess(true);
        return result;
    }

    @ResponseBody
    @RequestMapping("updateUserPhoto")
    public Object updateUserPhoto(@RequestParam("multipartFile") MultipartFile multipartFile){
        SysUser sysUser = getSysUser();
        SysFile file = sysFileService.uploadImageByModule("user", sysUser);
        sysUser.setUserPhoto(file.getFileId());
        //更新用户
        userService.updateUser(sysUser);
        SysUser newUser = userService.findById(sysUser.getUserId());
        session.setAttribute(CommonConstants.SESSION_USER,newUser);
        result.setData(file);
        result.setSuccess(true);
        return result;
    }


    @RequestMapping("friend")
    public String friend(){
        SysUser sysUser = getSysUser();
        List<SysUser> sysUsers = userService.selectFriendById(sysUser.getUserId());
        reqData.put("sysUser",sysUser);
        reqData.put("sysUsers",sysUsers);
        return "java/user/friend";
    }

    @ResponseBody
    @RequestMapping("friendOrMessageList")
    public Object friendOrMessageList(@RequestParam("type") String type){
        SysUser sysUser = getSysUser();
        List<SysUser> all =null;
        if(!StringUtils.isEmpty(type)&&type.equals("friend")){
            all = userService.findAll(sysUser.getUserId());
        }else{
            all = userService.findAllMessageUsersByUserId(sysUser.getUserId());
        }
        result.setSuccess(true);
        result.setData(all);
        return result;
    }

    @RequestMapping("/toAddfriend")
    public String toAddfriend(){
        SysUser sysUser = getSysUser();
        reqData.put("sysUser",sysUser);
        return "java/user/toAddfriend";
    }

    @ResponseBody
    @RequestMapping("/searchUsersByNameOrAccount")
    public Object searchUsersByNameOrAccount(@RequestParam("userName") String userName){
        List<SysUser> sysUsers = userService.searchUsersByNameOrAccount(userName);
        result.setData(sysUsers);
        return result;
    }

    @ResponseBody
    @RequestMapping("/addUser")
    public Object addUser(@RequestParam("userId") Integer userId){
        SysUser self = getSysUser();
        List<Integer> list = new ArrayList<>();
        list.add(userId);
        userService.addFriends(self,list);
        result.setSuccess(true);
        return result;
    }

    @ResponseBody
    @RequestMapping("/messageByUserId")
    public Object messageByUserId(@RequestParam("userId") Integer userId){
        SysUser self = getSysUser();
        UserMessage message=new UserMessage();
        message.setIsRead(10);
        message.setSenderId(self.getUserId());
        message.setReceiverId(userId);
        message.setMessageType("1");
        message.setMessageContent("");
        message.setMessageTime(DateUtils.getWebDate());
        userService.saveMessage(message);
        SysUser messageUser = userService.findById(userId);

        result.setData(messageUser);
        result.setSuccess(true);
        return result;
    }
    @ResponseBody
    @RequestMapping("/findAllMessageByUserId")
    public Object findAllMessageByUserId(){
        SysUser self = getSysUser();
        List<SysUser> users = userService.findAllMessageUsersByUserId(self.getUserId());
        result.setData(users);
        result.setSuccess(true);
        return result;
    }
    @ResponseBody
    @RequestMapping("/findMessageByUserId")
    public Object findMessageByUserId(@RequestParam("userId") Integer userId){
        SysUser self = getSysUser();
        List<UserMessage> messages = userService.findMessageByUserId(self.getUserId(),userId);
        result.setData(messages);
        result.setSuccess(true);
        return result;
    }

}
