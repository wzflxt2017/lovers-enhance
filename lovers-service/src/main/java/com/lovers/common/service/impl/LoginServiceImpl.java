package com.lovers.common.service.impl;


import com.lovers.common.domain.SysUser;
import com.lovers.common.mapper.SysUserMapper;
import com.lovers.common.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@com.alibaba.dubbo.config.annotation.Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private SysUserMapper sysUserMapper;


    public int addOne(SysUser sysUser) {

        return sysUserMapper.insert(sysUser);
    }

    public int addList(List<SysUser> sysUsers) {
        return 0;
    }

    public int deleteById(Integer userId) {
        return sysUserMapper.deleteByPrimaryKey(userId);
    }

    public int updateOne(SysUser sysUser) {
        return sysUserMapper.updateByPrimaryKey(sysUser);
    }

    public SysUser findById(Integer userId) {
        return sysUserMapper.selectByPrimaryKey(userId);
    }

    public SysUser findByAccount(String userAccount) {
        return sysUserMapper.selectByAccount(userAccount);
    }


    public List<SysUser> findByName(String userName) {
//        SysUserExample userExample = new SysUserExample();
//        SysUserExample.Criteria criteria = userExample.createCriteria();
//        criteria.andUserNameEqualTo(userName);
//        return sysUserMapper.selectByExample(userExample);
        return null;
    }
}
