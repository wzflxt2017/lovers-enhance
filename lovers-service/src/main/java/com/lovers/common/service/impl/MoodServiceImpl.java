package com.lovers.common.service.impl;


import com.lovers.common.domain.SysUser;
import com.lovers.common.domain.UserMoodRecord;
import com.lovers.common.mapper.UserMoodRecordMapper;
import com.lovers.common.service.MoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

/**
 * @Auther: wangzefeng
 * @Date: 2019-09-27 21:14
 * @Description:
 */
@Service
@com.alibaba.dubbo.config.annotation.Service
public class MoodServiceImpl  implements MoodService {

    @Autowired
    UserMoodRecordMapper userMoodRecordMapper;


    public List<UserMoodRecord> findPage(List<SysUser> sysUsers) {
        List<UserMoodRecord> userMoodRecords = userMoodRecordMapper.selectByUsers(sysUsers);
        return userMoodRecords;
    }


    public int addOne(UserMoodRecord mood,SysUser sysUser) {
        mood.setCreateTime(Calendar.getInstance().getTime());
        mood.setUserId(sysUser.getUserId());
        int i= userMoodRecordMapper.insert(mood);
        return i;
    }


}
