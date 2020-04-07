package com.lsc.order.service.imp;

import com.lsc.order.dao.UserInfoMapper;
import com.lsc.order.entity.UserInfo;
import com.lsc.order.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoServiceImp implements UserInfoService {
    @Autowired
    UserInfoMapper userInfoMapper;

    @Override
    public List<UserInfo> listUser() {
        return null;
    }

    @Override
    public List<UserInfo> listApplyUser() {
        return  userInfoMapper.listApplyUser();
    }

    @Override
    public void addUser(UserInfo userInfo) {
        userInfoMapper.addUser(userInfo);
    }

    @Override
    public UserInfo getUser(UserInfo userInfo) {
        return userInfoMapper.getUser(userInfo);
    }

    @Override
    public UserInfo doLogin(UserInfo userInfo) {
        return userInfoMapper.doLogin(userInfo);
    }
}
