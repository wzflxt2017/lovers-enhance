package com.lovers.common.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.lovers.common.base.controller.CommonController;
import com.lovers.common.domain.SysFile;
import com.lovers.common.service.SysFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Auther: wangzefeng
 * @Date: 2019-10-18 10:28
 * @Description:
 */
@Controller
@RequestMapping("/sys/file")
public class FileController extends CommonController {

    @Reference
    private SysFileService sysFileService;

    @ResponseBody
    @RequestMapping("/loadImagesByIds")
    public Object loadImagesByIds(String imageId){
        SysFile sysFile = sysFileService.selectByPrimaryKey(Integer.parseInt(imageId));
        return sysFile;
    }

}
