package com.lsc.order.web;

import com.github.pagehelper.PageInfo;
import com.lsc.order.constant.ApplyStatus;
import com.lsc.order.entity.InputApply;
import com.lsc.order.entity.UserInfo;
import com.lsc.order.exception.MyException;
import com.lsc.order.service.InputApplyService;
import com.lsc.order.service.UserInfoService;
import com.lsc.order.util.ResultCode;
import com.lsc.order.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/InputApply")
public class InputApplyController {
    @Autowired
    InputApplyService inputApplyService;
    @Autowired
    UserInfoService userInfoService;

    /**
     *
     * @param pageNo
     * @param pageSize
     * @param code 1为我的入库申请，2待处理入库申请，3入库历史
     * @return
     */
    @GetMapping("/listInputApply")
    public Object listInputApply(@RequestParam(value="pageNo",defaultValue="1")int pageNo,
                              @RequestParam(value="pageSize",defaultValue="10")int pageSize,
                              @RequestParam(value="code",defaultValue = "1")int code,
                              HttpSession session){
        Map map = new HashMap();
        UserInfo userInfo = (UserInfo) session.getAttribute("UserInfo");
        if(null==userInfo)
            throw new MyException(ResultCode.NOT_LOGIN);
        int applicantId = userInfo.getUserId();
        PageInfo<InputApply> inputApplyPageInfo = inputApplyService.listInputApply(pageNo,pageSize,applicantId,code);
        map.put("inputApplyPageInfo",inputApplyPageInfo);
        return ResultUtil.success(map);
    }

    @PostMapping("/listInputApply")
    public Object addInputApply(@RequestBody InputApply inputApply, HttpServletRequest request){
        UserInfo userInfo = (UserInfo) request.getSession().getAttribute("UserInfo");
        int userId = userInfo.getUserId();
        inputApply.setApplicantId(userId);

        //设置总价
        int num= inputApply.getNum();
        BigDecimal num1 = new BigDecimal(num);
        BigDecimal price = inputApply.getPrice();
        BigDecimal totalPrice = price.multiply(num1);
        inputApply.setTotalPrice(totalPrice);

        //申请时间
        Date date = new Date();
       // DateTime dateTime = new DateTime();
        inputApply.setApplyTime(date);

        inputApply.setStatus(ApplyStatus.WAIT_TO_ENSURE);
        inputApplyService.addInputApply(inputApply);
        return ResultUtil.success();
    }

    /***
     * 首页 入库出库的数据
     * @return
     */
    @GetMapping("/mainInputApply")
    public Map mainInputApply(@RequestParam(value="pageNo",defaultValue="1")int pageNo,
                              @RequestParam(value="pageSize",defaultValue="10")int pageSize){
        Map map = new HashMap();
        Map map1 = inputApplyService.yesInputApply(pageNo,pageSize);

        map.put("inputApplyList",map1);
        return map;


    }

    @DeleteMapping("/listInputApply/{inputApplyId}")
    public String deleteInputApply(@PathVariable("inputApplyId") int inputApplyId){
        inputApplyService.deleteInputApply(inputApplyId);
        return null;
    }

    @PutMapping("/listInputApply/{inputApplyId}")
    public Object updateInputStatus(@PathVariable("inputApplyId") int inputApplyId,
                                    @RequestParam("status") String status) {
        Map map = new HashMap();
        map.put("inputApplyId",inputApplyId);
        map.put("status",status);
        inputApplyService.updateInputStatus(map);

        return ResultUtil.success();
    }
}
