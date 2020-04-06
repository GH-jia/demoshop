package com.example.demoshop.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demoshop.response.CommonReturnType;
import com.example.demoshop.service.model.WXSessionModel;
import com.example.demoshop.utils.HttpClientUtil;
import com.example.demoshop.utils.RedisUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/test")
public class testController {

    @Autowired
    RedisUtils redisUtils;

//    @GetMapping(value = "/test")
//    public String test(){
//        return "test";
//    }

    @GetMapping(value = "/getCode")
    @ResponseBody
    public CommonReturnType getCode(@Param("code")String code) throws IOException, URISyntaxException {
        System.out.println("code:"+code);

        String url = "https://api.weixin.qq.com/sns/jscode2session";
        Map<String,String> params = new HashMap<>();
        params.put("appid","wx1e42923fb8579089");
        params.put("secret","fa1c9f50df9a1a468c42904a6826d353");
        params.put("js_code",code);
        params.put("grant_type","authorization_code");
//        通过微信官方API获取openid和session_key
        String wxResult = HttpClientUtil.doGet(url, params);
        System.out.println(wxResult);
//        字符串转为对象
        WXSessionModel wxSessionModel = JSONObject.parseObject(wxResult, WXSessionModel.class);
//        session_key存入redis缓存
        redisUtils.putex("user-redis-session:"+wxSessionModel.getOpenid(),
                1000 *60 *30,
                wxSessionModel.getSession_key());
        return CommonReturnType.create("OK");
    }

}
