package com.example.demoshop.service.Impl;

import com.example.demoshop.dao.ShopCommodityDOMapper;
import com.example.demoshop.dao.ShopListDOMapper;
import com.example.demoshop.daoObject.ShopCommodityDO;
import com.example.demoshop.daoObject.ShopListDO;
import com.example.demoshop.error.BusinessException;
import com.example.demoshop.error.EmBusinessError;
import com.example.demoshop.service.ShopService;
import com.example.demoshop.service.model.CommodityModel;
import com.example.demoshop.service.model.ShopModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    ShopListDOMapper shopListDOMapper;
    @Autowired
    ShopCommodityDOMapper shopCommodityDOMapper;

    @Override
    public List<ShopModel> getShopList() throws BusinessException {

        List<ShopListDO> shopListDOList = shopListDOMapper.selectShopList();
        if (shopListDOList == null){
            throw new BusinessException(EmBusinessError.COMMON_ERROR,"shopListDOList is null");
        }
        List<ShopModel> shopModelList = shopListDOList.stream().map(shopListDO -> {
            ShopModel shopModel = converModelFromDataObject(shopListDO);
            return shopModel;
        }).collect(Collectors.toList());

        //cache


        return shopModelList;
    }

    private ShopModel converModelFromDataObject(ShopListDO shopListDO){
        if (shopListDO == null){
            return null;
        }
        ShopModel shopModel = new ShopModel();
        BeanUtils.copyProperties(shopListDO,shopModel);
        return shopModel;
    }
    private CommodityModel converModelFromDataObject(ShopCommodityDO shopCommodityDO){
        if (shopCommodityDO == null){
            return null;
        }
        CommodityModel commodityModel = new CommodityModel();
        BeanUtils.copyProperties(shopCommodityDO,commodityModel);
        return commodityModel;
    }

    @Override
    public List<CommodityModel> getShopCommodityList(int shopId) {
        List<ShopCommodityDO> shopCommodityDOList = shopCommodityDOMapper.selectShopCommodityListByShopId(shopId);
        if (shopCommodityDOList == null){
            return null;
        }
        List<CommodityModel> commodityModelList = shopCommodityDOList.stream().map(shopCommodityDO -> {
            CommodityModel commodityModel = converModelFromDataObject(shopCommodityDO);
            return commodityModel;
        }).collect(Collectors.toList());

        //cache


        return commodityModelList;
    }
}
