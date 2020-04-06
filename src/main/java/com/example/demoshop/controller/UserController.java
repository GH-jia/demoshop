package com.example.demoshop.controller;

import com.alibaba.druid.util.StringUtils;
import com.example.demoshop.controller.viewObject.UserVO;
import com.example.demoshop.error.BusinessException;
import com.example.demoshop.error.EmBusinessError;
import com.example.demoshop.response.CommonReturnType;
import com.example.demoshop.service.Impl.UserserviceImpl;
import com.example.demoshop.service.UserService;
import com.example.demoshop.service.model.UserModel;
import com.example.demoshop.utils.RedisUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.GenericDeclaration;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Random;

@Controller("user")
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    RedisUtils redisUtils;
    @Autowired
    UserService userService;



    @RequestMapping(value = "/getUserById")
    @ResponseBody
    public CommonReturnType getUserById(@Param("id")Integer id) throws BusinessException {
        UserVO userVO = new UserVO();
        UserModel userModel = userService.getUserById(id);
        if (userModel != null){
            BeanUtils.copyProperties(userModel,userVO);
        }
        else {
            throw new BusinessException(EmBusinessError.NOT_USER_ERROR);
        }

        return CommonReturnType.create(userVO);
    }

    @RequestMapping(value = "/register")
    @ResponseBody
    public CommonReturnType register(@Param("telphone") String telphone,
                                     @Param("otpCode") String otpCode,
                                     @Param("password") String password) throws BusinessException, NoSuchAlgorithmException {
//        String telphone = "1312345678";
//        String otpCode = "123456";
//        String password = "123456";

        String inCacheOtpCode = redisUtils.get(telphone);
        if (StringUtils.equals(otpCode,inCacheOtpCode)){
            throw new BusinessException(EmBusinessError.COMMON_ERROR,"otpCode error");
        }
        UserModel userModel = new UserModel();
        userModel.setTelphone(telphone);
        userModel.setEncrptPassword(this.EncodeByMd5(password));

        userService.register(userModel);
        return CommonReturnType.create(null);

    }
//用MD5给密码加密
    private String EncodeByMd5(String password) throws NoSuchAlgorithmException {

        MessageDigest md5 = MessageDigest.getInstance("MD5");
        Base64.Encoder encoder = Base64.getEncoder();
        String newstr = encoder.encodeToString(md5.digest(password.getBytes()));
        return newstr;
    }
//获取短信验证码
    @RequestMapping(value = "/getotpcode")
    public CommonReturnType getOtpCode(@Param("telphone") String telphone){
        Random random = new Random();
        int randomInt = random.nextInt(99999);
        randomInt += 100000;
        String otpcCode = String.valueOf(randomInt);
        redisUtils.put(telphone,otpcCode);

        //put the otpCode to user's email
        System.out.println("telphone:"+telphone+";"+"otpCode:"+otpcCode);

        return CommonReturnType.create(null);
    }
}
