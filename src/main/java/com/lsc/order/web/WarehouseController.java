package com.lsc.order.web;

import com.lsc.order.entity.Warehouse;
import com.lsc.order.service.WarehouseService;
import com.lsc.order.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Warehouse")
public class WarehouseController {
    @Autowired
    WarehouseService warehouseService;

    @GetMapping("/warehouses")
    public Object spareWarehouse(@RequestParam(value = "sneakersId") int sneakersId){
        List<Warehouse> warehouseList = warehouseService.list(sneakersId);
        return ResultUtil.success(warehouseList);
    }
}
