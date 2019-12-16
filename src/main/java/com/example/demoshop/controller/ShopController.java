package com.example.demoshop.controller;

import com.example.demoshop.controller.viewObject.CommodityVO;
import com.example.demoshop.controller.viewObject.ShopVO;
import com.example.demoshop.error.BusinessException;
import com.example.demoshop.error.EmBusinessError;
import com.example.demoshop.response.CommonReturnType;
import com.example.demoshop.service.Impl.ShopServiceImpl;
import com.example.demoshop.service.ShopService;
import com.example.demoshop.service.model.CommodityModel;
import com.example.demoshop.service.model.ShopModel;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.stream.Collectors;

@Controller(value = "shop")
@RequestMapping(value = "/shop")
public class ShopController extends BaseController {

    @Autowired
    ShopService shopService;

    @RequestMapping(value = "/getShopList")
    @ResponseBody
    public CommonReturnType getShopList() throws BusinessException {
        List<ShopModel> shopModelList = shopService.getShopList();
        if (shopModelList == null){
            throw new BusinessException(EmBusinessError.COMMON_ERROR,"shopModelList is null");
        }
        List<ShopVO> shopVOList = shopModelList.stream().map(shopModel -> {
            ShopVO shopVO = converVOFromModel(shopModel);
            return shopVO;
        }).collect(Collectors.toList());

        return CommonReturnType.create(shopModelList);
    }

    private ShopVO converVOFromModel(ShopModel shopModel){
        if (shopModel == null){
            return null;
        }
        ShopVO shopVO = new ShopVO();
        BeanUtils.copyProperties(shopModel,shopVO);
        return shopVO;
    }
    private CommodityVO converVOFromModel(CommodityModel commodityModel){
        if (commodityModel == null){
            return null;
        }
        CommodityVO commodityVO = new CommodityVO();
        BeanUtils.copyProperties(commodityModel,commodityVO);
        return commodityVO;
    }

    @RequestMapping(value = "/getShopCommodityList")
    @ResponseBody
    public CommonReturnType getShopCommodityList(@Param("shopId") int shopId) throws BusinessException {
        List<CommodityModel> commodityModelList = shopService.getShopCommodityList(shopId);
        if (commodityModelList == null){
            throw new BusinessException(EmBusinessError.COMMON_ERROR,"commodityModelList is null");
        }
        List<CommodityVO> commodityVOList = commodityModelList.stream().map(commodityModel -> {
            CommodityVO commodityVO = converVOFromModel(commodityModel);
            return commodityVO;
        }).collect(Collectors.toList());
        return CommonReturnType.create(commodityVOList);
    }


}
