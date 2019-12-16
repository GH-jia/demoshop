package com.example.demoshop.error;

public interface CommonError {
    public int getErrCode();
    public String getErrMsg();
    public CommonError setMsg(String msg);
}
