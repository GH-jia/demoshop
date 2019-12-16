package com.example.demoshop.service.model;

public class UserModel {
    private Integer id;
    private String telphone;
    private Double money;
    private String encrptPassword;
    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    public String getEncrptPassword() {
        return encrptPassword;
    }

    public void setEncrptPassword(String encrptPassword) {
        this.encrptPassword = encrptPassword;
    }


}
