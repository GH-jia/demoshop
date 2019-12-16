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
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public CommonReturnType exceptionHandler(HttpServletRequest request,Exception ex){
        Map<String,Object> response = new HashMap<>();
        if (ex instanceof BusinessException){
            BusinessException businessException = (BusinessException) ex;
            response.put("errCode",businessException.getErrCode());
            response.put("errMsg",businessException.getErrMsg());
        }
        else{
            response.put("errCode", EmBusinessError.COMMON_ERROR.getErrCode());
            response.put("errMsg",ex);
        }
        return CommonReturnType.create(response,"fail");
    }
}
