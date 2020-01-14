package com.lovers.common.service;

import com.lovers.common.domain.SysUser;

import java.util.List;

public interface LoginService {


    int addOne(SysUser sysUser);

    int addList(List<SysUser> sysUsers);

    int deleteById(Integer userId);

    int updateOne(SysUser sysUser);

    SysUser findById(Integer userId);

    SysUser findByAccount(String userAccount);

    List<SysUser> findByName(String userName);


}
