package com.lovers.common.service;


import com.lovers.common.domain.SysUser;
import com.lovers.common.domain.UserMessage;

import java.util.List;

/**
 * @Auther: wangzefeng
 * @Date: 2019-09-26 09:16
 * @Description:
 */
public interface UserService {

    List<SysUser> findByName(String userName);
    SysUser findById(Integer userId);
    List<SysUser> searchUsersByNameOrAccount(String userName);

    List<SysUser> selectFriendById(Integer userId);
    List<SysUser> findAll(Integer userId);
    List<SysUser> findAllByMessage(Integer userId);
    void updateUser(SysUser sysUser);

    void addFriends(SysUser self, List<Integer> friendIds);
    void messageByUserId(Integer sender, Integer receiver);
    void saveMessage(UserMessage message);
    List<UserMessage> findMessageByUserId(Integer sender, Integer receiver);

    List<SysUser> findAllMessageUsersByUserId(Integer userId);


}
