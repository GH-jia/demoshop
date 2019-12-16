package com.example.demoshop.service;

import com.example.demoshop.error.BusinessException;
import com.example.demoshop.service.model.UserModel;

public interface UserService {
    UserModel getUserById(Integer id) throws BusinessException;
    void register(UserModel userModel) throws BusinessException;
}
