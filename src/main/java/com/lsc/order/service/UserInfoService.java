package com.lsc.order.service;

import com.lsc.order.entity.UserInfo;

import java.util.List;

public interface UserInfoService {
    List<UserInfo> listUser();
    List<UserInfo> listApplyUser();

    void addUser(UserInfo userInfo);
    UserInfo getUser(UserInfo userInfo);

    UserInfo doLogin(UserInfo userInfo);
}
