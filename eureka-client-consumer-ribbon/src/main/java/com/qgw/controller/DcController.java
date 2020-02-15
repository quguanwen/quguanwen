package com.qgw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class DcController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/ribbon")
    public String dc() {
//        因为Spring Cloud Ribbon有一个拦截器，它能够在这里进行实际调用的时候，自动的
//        去选取服务实例，并将实际要请求的IP地址和端口替换这里的服务名，从而完成服务接口的调用
//        省去了:loadBalancerClient 手动获取服务地址
        return restTemplate.getForObject("http://eureka-client-provider/dc", String.class);
    }
}
