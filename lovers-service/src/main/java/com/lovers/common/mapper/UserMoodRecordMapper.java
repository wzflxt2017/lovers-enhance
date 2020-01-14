package com.lovers.common.mapper;


import com.lovers.common.domain.SysUser;
import com.lovers.common.domain.UserMoodRecord;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;


public interface UserMoodRecordMapper extends Mapper<UserMoodRecord> {

    List<UserMoodRecord> selectByUsers(@Param("sysUsers") List<SysUser> sysUsers);
}