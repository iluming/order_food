package com.lsc.order.dao;

import com.lsc.order.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserInfoMapper {
    List<UserInfo> listUser();

    List<UserInfo> listApplyUser();

    void addUser(UserInfo userInfo);
    UserInfo getUser(UserInfo userInfo);

    UserInfo doLogin(UserInfo userInfo);

}
