package com.example.demoshop.service;

import com.example.demoshop.error.BusinessException;
import com.example.demoshop.service.model.CommodityModel;
import com.example.demoshop.service.model.ShopModel;

import java.util.List;

public interface ShopService {
    public List<ShopModel> getShopList() throws BusinessException;
    public List<CommodityModel> getShopCommodityList(int shopId);
}
