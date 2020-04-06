package com.example.demoshop.controller;

import com.example.demoshop.error.BusinessException;
import com.example.demoshop.error.EmBusinessError;
import com.example.demoshop.response.CommonReturnType;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class BaseController {
//    全局捕获异常
    @ExceptionHandler(Exception.class)
//    改变服务器响应的状态码
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public CommonReturnType exceptionHandler(HttpServletRequest request,Exception ex){
        Map<String,Object> response = new HashMap<>();
        //instanceof是Java中的二元运算符，左边是对象，右边是类；当对象是右边类或子类所创建对象时，返回true；否则，返回false
//        检查异常是否为自定义BusinessException类型异常
        if (ex instanceof BusinessException){
            BusinessException businessException = (BusinessException) ex;
            response.put("errCode",businessException.getErrCode());
            response.put("errMsg",businessException.getErrMsg());
        }
        else{
            response.put("errCode", EmBusinessError.COMMON_ERROR.getErrCode());
            response.put("errMsg",ex);
        }
//        把返回信息装载到统一的返回数据类型中
        return CommonReturnType.create(response,"fail");
    }
}
