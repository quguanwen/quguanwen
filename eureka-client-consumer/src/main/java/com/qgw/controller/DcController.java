package com.qgw.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class DcController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    LoadBalancerClient loadBalancerClient;

    @GetMapping("/consumer")
    public String dc() {
        //通过loadBalancerClient对象从eureka中获取服务实例
        ServiceInstance serviceInstance = loadBalancerClient.choose("eureka-client-provider");
        //获取服务实例的访问地址
        String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/dc";
        log.info("消费者调用接口{}",url);
        //restTemplate对象实现真正调用,并获接口返回值
        return restTemplate.getForObject(url,String.class);
    }

}
