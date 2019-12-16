package com.example.demoshop.error;

public enum EmBusinessError implements CommonError {
    COMMON_ERROR(10001,"通用错误"),
    REGISTERED_ERROR(10002,"this telphone is registered"),
    PARAMETER_ERROR(10003,"missing parameter"),
    NOT_USER_ERROR(10004,"not found the user");

    ;
    private int errCode;
    private String errMsg;
    EmBusinessError(int errCode,String errMsg){
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    @Override
    public int getErrCode() {
        return this.errCode;
    }

    @Override
    public String getErrMsg() {
        return this.errMsg;
    }

    @Override
    public CommonError setMsg(String msg) {
        this.errMsg = msg;
        return this;
    }
}
