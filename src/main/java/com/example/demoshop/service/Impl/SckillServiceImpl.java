package com.example.demoshop.service.Impl;

import com.alibaba.druid.util.Utils;
import com.alibaba.fastjson.JSONObject;
import com.example.demoshop.controller.GreetingController;
import com.example.demoshop.dao.SckilledDOMapper;
import com.example.demoshop.daoObject.SckilledDO;
import com.example.demoshop.error.BusinessException;
import com.example.demoshop.error.EmBusinessError;
import com.example.demoshop.service.SckillService;
import com.example.demoshop.service.model.SckillModel;
import com.example.demoshop.utils.RedisUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.util.HtmlUtils;

import java.util.HashMap;
import java.util.Map;

@Service
public class SckillServiceImpl implements SckillService {

    @Autowired
    RedisUtils redisUtils;

    @Override

    //shopping cart
    public Map putSckill(SckillModel sckillModel) throws BusinessException {
        if (sckillModel.getCommodityId() == null
        || sckillModel.getCount() == null
        || sckillModel.getPrice() == null
        || sckillModel.getShopId() == null
        || sckillModel.getUserId() == null
        || StringUtils.isEmpty(sckillModel.getName())
        || sckillModel.getTotal() == null){
            throw new BusinessException(EmBusinessError.PARAMETER_ERROR);
        }

        //add sckillModel to cache
        String keyb = "shopUserId"+sckillModel.getUserId()+sckillModel.getShopId();
        String keya = "commodityId"+sckillModel.getCommodityId();
        Map<String,String> preMap = redisUtils.hget(keyb);
        if (preMap == null){
            preMap = new HashMap<>();
        }

        String strModel = JSONObject.toJSONString(sckillModel);

        preMap.put(keya,strModel);
        redisUtils.hput(keyb,preMap);
        return preMap;
    }

    @Autowired
    SckilledDOMapper sckilledDOMapper;

    @Autowired
    GreetingController greetingController;

    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;

    private void sendSckillDO(SckilledDO sckilledDO){
        simpMessagingTemplate.convertAndSend("/topic/greetings",sckilledDO);
    }

    //shoped
    @Transactional
    public void sckilled(String key) throws Exception {
        Map<String,String> map = redisUtils.hget(key);
        if (map != null){
            for (Map.Entry<String,String> entry:
                    map.entrySet()) {
                String strModel = entry.getValue();
                SckillModel sckillModel = JSONObject.parseObject(strModel,SckillModel.class);
                SckilledDO sckillDO = new SckilledDO();
                BeanUtils.copyProperties(sckillModel,sckillDO);
                sckilledDOMapper.insertSelective(sckillDO);
                int sckillId = sckillDO.getSckillId();
                SckilledDO sckilledDO2 = sckilledDOMapper.selectByPrimaryKey(sckillId);
                if (sckilledDO2 != null){
                    System.out.println("send message!");
                    sendSckillDO(sckilledDO2);
                }
            }
        }

    }


}

