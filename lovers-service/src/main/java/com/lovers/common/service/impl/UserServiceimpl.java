package com.lovers.common.service.impl;


import com.lovers.common.domain.SysUser;
import com.lovers.common.domain.UserMessage;
import com.lovers.common.mapper.SysUserMapper;
import com.lovers.common.mapper.UserFriendMapper;
import com.lovers.common.mapper.UserMessageMapper;
import com.lovers.common.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @Auther: wangzefeng
 * @Date: 2019-09-26 09:16
 * @Description:
 */
@Service
@com.alibaba.dubbo.config.annotation.Service
public class UserServiceimpl implements UserService {


    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private UserFriendMapper userFriendMapper;

    @Autowired
    private UserMessageMapper userMessageMapper;

    public List<SysUser> findByName(String userName) {
        return null;
    }

    public SysUser findById(Integer userId) {
        SysUser sysUser = new SysUser();
        sysUser.setUserId(userId);
        return sysUserMapper.selectOne(sysUser);
    }

    public List<SysUser> searchUsersByNameOrAccount(String userName) {
        return null;
    }

    public List<SysUser> selectFriendById(Integer userId) {
        List<SysUser> sysUsers = sysUserMapper.selectFriendByUserId(userId);
        return sysUsers;
    }

    public List<SysUser> findAll(Integer userId) {
        List<SysUser> sysUsers = sysUserMapper.selectFriendByUserId(userId);
        return sysUsers;
    }

    public List<SysUser> findAllByMessage(Integer userId) {
        return null;
    }

    public void updateUser(SysUser sysUser) {
        Example example=new Example(SysUser.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("userId",sysUser.getUserId());
        sysUserMapper.updateByExample(sysUser,example);
    }

    public void addFriends(SysUser self, List<Integer> friendIds) {

    }

    public void messageByUserId(Integer sender, Integer receiver) {

    }

    public void saveMessage(UserMessage message) {

    }

    public List<UserMessage> findMessageByUserId(Integer sender, Integer receiver) {
        return null;
    }

    public List<SysUser> findAllMessageUsersByUserId(Integer userId) {
        List<SysUser> users = sysUserMapper.findAllMessageUsersByUserId(userId);
        return users;
    }
}
