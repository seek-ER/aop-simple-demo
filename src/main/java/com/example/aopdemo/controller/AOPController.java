package com.example.aopdemo.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aop")
public class AOPController {
    @GetMapping("/getTest")
    public JSONObject aopTest(){
        return JSON.parseObject("{\"message\":\"SUCCESS\",\"code\":200}");
    }
}
