package com.lsc.order.entity;

import lombok.Data;

@Data
public class Warehouse {
    /**
     * 为什么是多对对  仓库 --- 球鞋  ，因为可以多次出入库，万一原本的库满了，可以放其他库
     * */
    private int warehouseId;
    private String warehouseName;
    private int maxStorage;
    private int spareNum;
    private String status; //1.闲置（没有球鞋 2.空闲（有球鞋 ，3.饱和（80%


}
