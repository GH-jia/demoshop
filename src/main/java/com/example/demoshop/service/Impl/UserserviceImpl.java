package com.example.demoshop.service.Impl;

import com.example.demoshop.dao.UserInfoDOMapper;
import com.example.demoshop.dao.UserPasswordDOMapper;
import com.example.demoshop.daoObject.UserInfoDO;
import com.example.demoshop.daoObject.UserPasswordDO;
import com.example.demoshop.error.BusinessException;
import com.example.demoshop.error.EmBusinessError;
import com.example.demoshop.service.UserService;
import com.example.demoshop.service.model.UserModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.beans.Transient;
import java.sql.SQLIntegrityConstraintViolationException;

@Service
public class UserserviceImpl implements UserService {

    @Autowired
    UserInfoDOMapper userInfoDOMapper;
    @Autowired
    UserPasswordDOMapper userPasswordDOMapper;

    @Override
    public UserModel getUserById(Integer id) throws BusinessException {
        UserInfoDO userInfoDO = userInfoDOMapper.selectByPrimaryKey(id);
        UserModel userModel = new UserModel();
        if (userInfoDO != null){
            BeanUtils.copyProperties(userInfoDO,userModel);
        }
        else {
            throw new BusinessException(EmBusinessError.NOT_USER_ERROR);
        }

        return userModel;
    }

    @Override
    @Transactional
    public void register(UserModel userModel) throws BusinessException {
        if (userModel == null){
                                                            throw new BusinessException(EmBusinessError.COMMON_ERROR,"not input");
        }
        if (StringUtils.isEmpty(userModel.getTelphone())
            || StringUtils.isEmpty(userModel.getEncrptPassword())){
            throw new BusinessException(EmBusinessError.COMMON_ERROR,"telphone or password is null");
        }
        //userModel -> userDO
        UserInfoDO userInfoDO = convertFromModel(userModel);
        try{
            userInfoDOMapper.insertSelective(userInfoDO);
        }catch (Exception e){
            if (e.getCause() instanceof SQLIntegrityConstraintViolationException){
                throw new BusinessException(EmBusinessError.REGISTERED_ERROR);
            }
        }



        userModel.setId(userInfoDO.getId());
        UserPasswordDO userPasswordDO = convertPasswordFromModel(userModel);
        userPasswordDOMapper.insertSelective(userPasswordDO);
    }

    private UserPasswordDO convertPasswordFromModel(UserModel userModel){
        if(userModel == null){
            return null;
        }
        UserPasswordDO userPasswordDO = new UserPasswordDO();
        userPasswordDO.setEncrptPassword(userModel.getEncrptPassword());
        userPasswordDO.setUserId(userModel.getId());
        return userPasswordDO;
    }

    private UserInfoDO convertFromModel(UserModel userModel){
        if (userModel == null){
            return null;
        }
        UserInfoDO userInfoDO = new UserInfoDO();
        BeanUtils.copyProperties(userModel,userInfoDO);

        return userInfoDO;
    }

}
