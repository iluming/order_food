package com.lsc.order.web;

import com.github.pagehelper.PageInfo;
import com.lsc.order.entity.Sneakers;
import com.lsc.order.exception.MyException;
import com.lsc.order.service.SneakersService;
import com.lsc.order.util.ResultCode;
import com.lsc.order.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Sneakers")
public class SneakersController {
    @Autowired
    SneakersService sneakersService;

    /**
     *
     * @param pageNo   要显示第几页内容,当是 999时，不用分页
     * @param pageSize    一页显示多少条
     * @return
     */
    @GetMapping("/listSneakers")
    public Map listSneakers(@RequestParam(value="pageNo",defaultValue="1")int pageNo,
                            @RequestParam(value="pageSize",defaultValue="10")int pageSize) {
        Map map = new HashMap();
        if (pageNo == 999){ //不用分页
            List<Sneakers> sneakersList = sneakersService.listSneakers();
            map.put("sneakersList",sneakersList);
        }else {
            PageInfo<Sneakers> sneakersPageInfo = sneakersService.listSneakers(pageNo,pageSize);
            map.put("sneakersPageInfo",sneakersPageInfo);
            map.put("listSneakers",sneakersPageInfo.getList());
        }
        return map;
    }

    @GetMapping("/getSneakers")
    public Map getSneakers(int sneakersId){
        Map map = new HashMap();
        Sneakers sneakers = sneakersService.getSneaker(sneakersId);
        map.put("sneakers",sneakers);
        return map;
    }

    @PostMapping("/addSneakers")
    public Object addSneakers(@RequestBody Sneakers sneakers){
        try{
            sneakersService.addSneakers(sneakers);
        }catch (Exception e){
            throw new MyException(ResultCode.PARAMS_ERROR);
        }
        return ResultUtil.success();
    }

    @PutMapping("/upDateSneakers")
    public Object upDateSneakers(@RequestBody Sneakers sneakers){
        try{
            sneakersService.upDateSneakers(sneakers);
        }catch (Exception e){
            throw new MyException(ResultCode.PARAMS_ERROR);
        }
        return ResultUtil.success();
    }

    @DeleteMapping("/deleteSneakers")
    public Object deleteSneakers(int sneakersId){
        try{
            sneakersService.deleteSneakers(sneakersId);
        }catch (Exception e){
            throw new MyException(ResultCode.PARAMS_ERROR);
        }
        return ResultUtil.success();
    }
}
