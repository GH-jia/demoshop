package com.example.demoshop.controller;

import com.example.demoshop.controller.BaseController;
import com.example.demoshop.controller.viewObject.ShopedVO;
import com.example.demoshop.response.CommonReturnType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/shoped")
public class ShopedController extends BaseController {
    @RequestMapping(value = "shoped")
    public CommonReturnType shoped(){
        ShopedVO shopedVO = new ShopedVO(1,1,1,10.0);
        return CommonReturnType.create("OK");
    }

}
