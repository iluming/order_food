package com.lsc.order.web;

import com.lsc.order.entity.UserInfo;
import com.lsc.order.exception.MyException;
import com.lsc.order.service.UserInfoService;
import com.lsc.order.util.EncrypeUtil;
import com.lsc.order.util.ResultCode;
import com.lsc.order.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class UserInfoController {
    @Autowired
    UserInfoService userInfoService;

    @PostMapping("/login")
    public Object login( HttpSession session,
                        @RequestParam(value = "account")String account,
                        @RequestParam(value = "pwd" ) String pwd) throws Exception {
        UserInfo userInfo = new UserInfo(account, pwd);
        userInfo.setPwd(EncrypeUtil.shaEncode(userInfo.getPwd()));
        UserInfo userInfo1 = userInfoService.doLogin(userInfo);
        if (null == userInfo1) {
            throw new MyException(ResultCode.NOT_ACCOUNT);
        }
        session.setAttribute("UserInfo", userInfo1);
        System.out.println(session.getAttribute("UserInfo"));
        return ResultUtil.success();
    }

    @PostMapping("/register")
    public Object register(@RequestBody UserInfo userInfo) throws Exception {
      /*  UserInfo userInfo1 = userInfoService.getUser(userInfo);
        if (null != userInfo1){
            return  ResultUtil.success("账号已存在");
        }*/
    //    userInfo.setAccount(userInfo.getTelephone());
        userInfo.setPwd(EncrypeUtil.shaEncode(userInfo.getPwd()));
        userInfoService.addUser(userInfo);
        return ResultUtil.success("注册成功，等待管理员通过");
    }

    @GetMapping("/listApplyUser")
    public Object listApplyUser(){
        List<UserInfo> userInfoList = userInfoService.listApplyUser();
        return ResultUtil.success(userInfoList);
    }
}
