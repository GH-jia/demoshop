package com.example.demoshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class testController {

    @GetMapping(value = "/test")
    public String test(){
        return "test";
    }
}
