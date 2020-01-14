package com.lovers.common.mapper;

import com.lovers.common.domain.SysUser;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface SysUserMapper extends Mapper<SysUser> {

    SysUser selectByAccount(@Param("userAccount") String userAccount);
    List<SysUser> selectFriendByUserId(@Param("userId") Integer userId);
    List<SysUser> selectFriendByMessage(@Param("userId") Integer userId);
    List<SysUser> findAllMessageUsersByUserId(@Param("userId") Integer userId);


}