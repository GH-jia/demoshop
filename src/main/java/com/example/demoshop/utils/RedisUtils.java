package com.example.demoshop.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Map;

@Component
public class RedisUtils {
    @Autowired
    JedisPool jedisPool;

    public String put(String key,String value){
        Jedis jedis = jedisPool.getResource();
        String strResult = "";
        try{
            strResult = jedis.set(key,value);
        }catch (Exception e){
            e.getStackTrace();
        }finally {
            jedis.close();
        }
        return strResult;
    }
    public long hput(String key, Map map){
        Jedis jedis = jedisPool.getResource();
        long result = 0;
        try{
            result = jedis.hset(key,map);
        }catch (Exception e){
            e.getStackTrace();
        }finally {
            jedis.close();
        }
        return result;
    }

    public Map hget(String key){
        Jedis jedis = jedisPool.getResource();
        Map map = null;
        try{
            map = jedis.hgetAll(key);
        }catch (Exception e){
            e.getStackTrace();
        }finally {
            jedis.close();
        }
        return map;
    }

    public String putex(String key,int seconds,String value){
        Jedis jedis = jedisPool.getResource();
        String strResult = "";
        try{
            strResult = jedis.setex(key,seconds,value);


        }catch (Exception e){
            e.getStackTrace();
        }finally {
            jedis.close();
        }
        return strResult;
    }

    public String get(String key){
        Jedis jedis = jedisPool.getResource();
        String strResult = "";
        try{
            strResult = jedis.get(key);
        }catch (Exception e){
            e.getStackTrace();
        }finally {
            jedis.close();
        }
        return strResult;
    }
}
