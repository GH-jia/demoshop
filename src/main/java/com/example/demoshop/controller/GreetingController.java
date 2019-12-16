package com.example.demoshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class GreetingController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

//    @MessageMapping("/hello")
//    @SendTo("/topic/greetings")
//    public Test greeting() throws Exception {
//        Thread.sleep(1000); // simulated delay
//        Test test = new Test("hj");
//        return test;
//    }

    public Test greeting() throws Exception {
        Thread.sleep(1000); // simulated delay
        Test test = new Test("hj");
        simpMessagingTemplate.convertAndSend("/topic/greetings",test);
        return test;
    }

}

class Test{
    public String name;
    public Test(String name){
        this.name=name;
    }
}
