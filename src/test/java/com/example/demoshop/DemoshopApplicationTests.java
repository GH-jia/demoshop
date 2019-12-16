package com.example.demoshop;

import com.example.demoshop.utils.RedisUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class DemoshopApplicationTests {

    @Test
    void contextLoads() {
    }

    @Resource
    DataSource dataSource;




    @Test
    void testDataSource() throws SQLException {
        System.out.println(dataSource.getClass());
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        System.out.println(connection.getMetaData().getURL());
    }

    @Autowired
    RedisUtils redisUtils;
    @Test
    void testRedis(){
        String key = "test";
        Map<String,String> map = new HashMap<>();
        map.put("1","a");
        map.put("2","b");

        redisUtils.hput(key,map);

    }

}
