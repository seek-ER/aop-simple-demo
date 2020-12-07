package com.example.aopdemo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.*;
import com.example.aopdemo.annotation.PermissionAnnotation;

@RestController
@RequestMapping("/permission")
public class TestController {
    @PostMapping("/check")
    // 添加这个注解
    @PermissionAnnotation()
    public JSONObject getGroupList(@RequestBody JSONObject request) {
        return JSON.parseObject("{\"message\":\"SUCCESS\",\"code\":200}");
    }
}