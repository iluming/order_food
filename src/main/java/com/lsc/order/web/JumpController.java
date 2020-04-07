package com.lsc.order.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JumpController {
    @GetMapping(value="/login")
    public String login(){
        return "login/index";
    }
    @GetMapping(value="/register")
    public String register(){
        return "login/reg";
    }

    @GetMapping(value = "/admin")
    public String admin(){
        return "admin/index";
    }

    @GetMapping(value = "/main")
    public String main(){
        return "admin/main";
    }

    @GetMapping(value = "/sneakers")
    public String sneakers(){
        return "admin/sneakers";
    }

    @GetMapping(value = "/inputApply")
    public String inputApply(){
        return "admin/inputApply";
    }

    @GetMapping(value = "/inputHistory")
    public String inputHistory(){
        return "admin/inputHistory";
    }

    @GetMapping(value = "/inputWait")
    public String inputWait(){
        return "admin/inputWait";
    }

    @GetMapping(value = "/outputApply")
    public String outputApply(){
        return "admin/outputApply";
    }

    @GetMapping(value = "/outputHistory")
    public String outputHistory(){
        return "admin/outputHistory";
    }

    @GetMapping(value = "/outputWait")
    public String outputWait(){
        return "admin/outputWait";
    }

    @GetMapping(value = "/inventoryInfo")
    public String inventoryInfo(){
        return "admin/inventoryInfo";
    }

    @GetMapping(value = "/personInfo")
    public String personInfo(){
        return "admin/personInfo";
    }

    @GetMapping(value = "/addInput")
    public String addInput(){
        return "admin/addInput";
    }


}
