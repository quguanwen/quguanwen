package com.qgw.controller;

import com.qgw.feign.DcClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DcController {

    //fegin实现了当作本地方法调用
    @Autowired
    DcClient dcClient;

    @GetMapping("/feignConsumer")
    public String dc() {
        return dcClient.consumer();
    }
}
