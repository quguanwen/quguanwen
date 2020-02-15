package com.qgw.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DcServiceImpl implements DcService {

    @Autowired
    RestTemplate restTemplate;

    //TODO 正常的服务消费函数
    @HystrixCommand(fallbackMethod = "fallback")
    public String consumer() {
        return restTemplate.getForObject("http://eureka-client-provider/dc", String.class);
    }

    //TODO 服务降级后执行的函数
    public String fallback() {
        return "服务降级成功";
    }

}
