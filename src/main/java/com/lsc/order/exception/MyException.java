package com.lsc.order.exception;


import com.lsc.order.util.ResultCode;

public class MyException extends RuntimeException{

    private String code;
    private String msg;

    public MyException(String code, String msg){
        super(msg);
        this.code = code;
    }

    public MyException(ResultCode exception) {
        this.code = exception.val();
        this.msg = exception.msg();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
