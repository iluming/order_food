package com.lsc.order.constant;

public class ApplyStatus {
    public static final String WAIT_TO_ENSURE = "待审核";//待审核
    public static final String PACKAGED = "已打包";//打包,其中入库操作不需要打包
    public static final String ENSURE = "已确认";//确认
    public static final String REFUSED = "被拒绝";//确认
    public static final String TURN_BACK = "已退回";//不良品退回

    public static final String IDLE = "闲置";//确认
    public static final String SPARE = "空余";//确认
    public static final String SATURATION = "饱和";//确认


}
