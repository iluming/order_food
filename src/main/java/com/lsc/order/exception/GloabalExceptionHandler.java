package com.lsc.order.exception;

import com.lsc.order.util.Result;
import com.lsc.order.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class GloabalExceptionHandler {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e){
        if(e instanceof MyException){
            logger.error("业务日志",e);
            MyException myException = (MyException) e;
            return  ResultUtil.error(myException.getCode(),myException.getMsg());
        }
        logger.error("系统日志",e);
        return ResultUtil.error("1000","业务繁忙");
    }


 
}