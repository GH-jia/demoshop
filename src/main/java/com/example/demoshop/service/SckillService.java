package com.example.demoshop.service;

import com.example.demoshop.error.BusinessException;
import com.example.demoshop.service.model.SckillModel;

import java.util.Map;

public interface SckillService {
    public Map putSckill(SckillModel sckillModel) throws BusinessException;
    public void sckilled(String key) throws Exception;
}
