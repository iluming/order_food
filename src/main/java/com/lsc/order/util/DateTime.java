package com.lsc.order.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateTime {
    public String getNowTime() {
        Calendar cal = Calendar.getInstance();
//n为推迟的周数，1本周，-1向前推迟一周，2下周，依次类推
        int n = 0;
        String monday;
        cal.add(Calendar.DATE, n * 7);
//想周几，这里就传几Calendar.MONDAY（TUESDAY...）
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        monday = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());

        System.out.println("monday"+monday);
        return monday;
    }
    public String getLastTime() {

        Calendar calendar = Calendar.getInstance();
//n为推迟的周数，1本周，-1向前推迟一周，2下周，依次类推
        int n = -1;
        String lastmonday;
        calendar.add(Calendar.DATE, n*7);
//想周几，这里就传几Calendar.MONDAY（TUESDAY...）
        calendar.set(Calendar.DAY_OF_WEEK,Calendar.MONDAY);
        lastmonday = new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime());
        System.out.println("lastmonday"+lastmonday);
        return lastmonday;
    }

    public String getNowTimeDay() {
        String newTime;
        Calendar cal = Calendar.getInstance();
        newTime= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(cal.getTime());
        System.out.println("newTime"+newTime);
        return newTime;
    }
}
