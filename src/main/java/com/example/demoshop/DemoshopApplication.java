package com.example.demoshop;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = "com.example.demoshop.dao")
public class DemoshopApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoshopApplication.class, args);
    }

}
