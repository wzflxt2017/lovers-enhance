package com.lovers.common.service;

import com.lovers.common.domain.SysFile;
import com.lovers.common.domain.SysUser;

import java.util.List;

/**
 * @Auther: wangzefeng
 * @Date: 2019-09-28 16:46
 * @Description:
 */
public interface SysFileService {
//    long countByExample(SysFileExample example);

    int deleteByPrimaryKey(Integer fileId);

    int insert(SysFile record);

//    int insertSelective(SysFile record);

    List<SysFile> selectByIds(String fileIds);
    SysFile selectByPrimaryKey(Integer fileId);


//    int updateByPrimaryKeySelective(SysFile record);

    int updateByPrimaryKey(SysFile record);

    SysFile uploadImageByModule(String module, SysUser sysUser);
}
