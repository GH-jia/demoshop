package com.example.demoshop.controller.viewObject;

import com.example.demoshop.daoObject.ShopListDO;

import java.util.Arrays;
import java.util.Objects;

public class ShopedVO {
    private int userId;//用户id
    private int commodityId;//商品id
//    商品数量
    private int count;
//    商品价格
    private double price;

    public ShopedVO(){}
    public ShopedVO(int userId,int commodityId,int count,double price){
        this.userId = userId;
        this.commodityId = commodityId;
        this.count = count;
        this.price = price;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(int commodityId) {
        this.commodityId = commodityId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
