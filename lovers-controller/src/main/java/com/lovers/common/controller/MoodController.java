package com.lovers.common.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.lovers.common.base.controller.CommonController;
import com.lovers.common.domain.SysFile;
import com.lovers.common.domain.SysUser;
import com.lovers.common.domain.UserMoodRecord;
import com.lovers.common.service.MoodService;
import com.lovers.common.service.SysFileService;
import com.lovers.common.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: wangzefeng
 * @Date: 2019-09-26 09:10
 * @Description:
 */
@Controller
@RequestMapping("/mood")
public class MoodController extends CommonController {


    @Reference
    private MoodService moodService;

    @Reference
    private UserService userService;

    @Reference
    private SysFileService sysFileService;

    @RequestMapping("/index")
    public String index(){
        SysUser sysUser = getSysUser();
        List<SysUser> sysUsers = userService.selectFriendById(sysUser.getUserId());
        return "java/mood/index";
    }

    @ResponseBody
    @RequestMapping("/moodList")
    public Object moodList(){
        SysUser sysUser = getSysUser();
        List<SysUser> sysUsers = userService.selectFriendById(sysUser.getUserId());
        List<UserMoodRecord> page = moodService.findPage(sysUsers);
        result.setData(page);
        return result;
    }

    @ResponseBody
    @RequestMapping("/uploadImages")
    public Object uploadImages(List<MultipartFile> files){
        List<SysFile> list=new ArrayList<>();
        for(MultipartFile file:files){
//            String fileName = file.getOriginalFilename();
//            String[] split = fileName.split("\\.");
//            SysFile sysFile = new SysFile();
//            sysFile.setFileFullName(fileName);
//            sysFile.setFileSuffix("."+split[1]);
//            sysFile.setFileName(split[0]);
//            sysFile.setFileType(split[1]);
//            sysFile.setForModule("mood");
//            sysFile.setUserId(sysUser.getUserId());
//            sysFile.setUploadTime(Calendar.getInstance().getTime());
//            int insert = sysFileService.insert(sysFile);
//            try {
//                File file1 = new File(getRootPath()+"mood"+ File.separator+sysFile.getFileId()+"_"+sysFile.getFileFullName());
//                list.add(sysFile);
//                if(!file1.exists()){
//                    file1.mkdirs();
//                }
//                file.transferTo(file1);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
            SysFile mood = sysFileService.uploadImageByModule("mood", getSysUser());
            list.add(mood);
        }
        result.setSuccess(true);
        result.setData(list);
        return result;
    }

    @ResponseBody
    @RequestMapping("/removeImage")
    public Object removeImage(){

        result.setSuccess(true);
        return result;
    }


    @RequestMapping("/toAddOrEditMood")
    public String toAddOrEditMood(){
        return "java/mood/addOrEditMood";
    }


    @ResponseBody
    @RequestMapping("/addMood")
    public Object addMood(UserMoodRecord mood){
        moodService.addOne(mood,getSysUser());
        result.setSuccess(true);
        return result;
    }

    @RequestMapping("/toUploadImage")
    public String toUploadImage(){
        return "java/mood/uploadImage";
    }





}
