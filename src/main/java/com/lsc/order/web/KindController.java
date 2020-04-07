package com.lsc.order.web;

import com.lsc.order.entity.Kind;
import com.lsc.order.service.KindService;
import com.lsc.order.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class KindController {
    @Autowired
    KindService kindService;

    @GetMapping("/kinds")
    public Object listKind(){
        List<Kind> kindList = kindService.listKind();
        return ResultUtil.success(kindList);
    }
}
