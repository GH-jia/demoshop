package com.example.demoshop.controller;

import com.example.demoshop.error.BusinessException;
import com.example.demoshop.response.CommonReturnType;
import com.example.demoshop.service.SckillService;
import com.example.demoshop.service.model.SckillModel;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@RequestMapping(value = "/sckill")
@Controller(value = "sckill")
public class SckillController extends BaseController {

    @Autowired
    SckillService sckillService;

    @RequestMapping(value = "/putSckill")
    @ResponseBody
    public CommonReturnType putSckill(@Param("commodityId")Integer commodityId,
                                      @Param("userId")Integer userId,
                                      @Param("shopId")Integer shopId,
                                      @Param("name")String name,
                                      @Param("price")Double price,
                                      @Param("count")Integer count) throws BusinessException {
        SckillModel sckillModel = new SckillModel();
        sckillModel.setCommodityId(commodityId);
        sckillModel.setUserId(userId);
        sckillModel.setShopId(shopId);
        sckillModel.setName(name);
        sckillModel.setPrice(price);
        sckillModel.setCount(count);
        double total = count*price;
        sckillModel.setTotal(total);

        Map resultMap = sckillService.putSckill(sckillModel);

        return CommonReturnType.create(resultMap);
    }

    @RequestMapping(value = "/sckilled")
    @ResponseBody
    public CommonReturnType sckilled(@Param("shopId")Integer shopId,
                                     @Param("userId")Integer userId) throws Exception {
        String key = "shopUserId"+userId+shopId;
        sckillService.sckilled(key);
        return CommonReturnType.create(null);
    }

}
