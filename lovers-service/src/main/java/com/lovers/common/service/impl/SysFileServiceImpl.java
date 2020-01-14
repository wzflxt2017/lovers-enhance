package com.lovers.common.service.impl;


import com.lovers.common.domain.SysFile;
import com.lovers.common.domain.SysUser;
import com.lovers.common.service.SysFileService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: wangzefeng
 * @Date: 2019-09-28 16:46
 * @Description:
 */
@Service
@com.alibaba.dubbo.config.annotation.Service
public class SysFileServiceImpl implements SysFileService {


    @Value("${lovers.rootPath}")
    private String rootPath;

    public int deleteByPrimaryKey(Integer fileId) {
        return 0;
    }

    public int insert(SysFile record) {
        return 0;
    }

    public List<SysFile> selectByIds(String fileIds) {
        return null;
    }

    public SysFile selectByPrimaryKey(Integer fileId) {
        return null;
    }

    public int updateByPrimaryKey(SysFile record) {
        return 0;
    }

    public SysFile uploadImageByModule(String module, SysUser sysUser) {
        return null;
    }
}
