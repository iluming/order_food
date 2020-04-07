package com.lsc.order.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.annotation.Transient;

@Data
public class UserInfo {

    private int userId;
    private String  account;
    private String pwd;
    private String userName;
    private String icon;
    private String company;
    private String telephone;
    private String sector;  //部门
    private String partition; //所属公司分区
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private String entryTime;
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private String createTime;

    @Transient
    private Role role;

    public UserInfo(){}
    public UserInfo(String account, String pwd) {
        this.account = account;
        this.pwd = pwd;
    }

}
