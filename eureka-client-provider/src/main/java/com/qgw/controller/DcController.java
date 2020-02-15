package com.qgw.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Slf4j
public class DcController {

    @Autowired
    DiscoveryClient discoveryClient;

    @GetMapping("/dc")
    public String dc() throws InterruptedException {
//        Thread.sleep(5000L);
//        discoveryClient屏蔽了实现,不管是eureka还是consul都没问题
        String services = "Services: " + discoveryClient.getServices();
        log.info("{}", services);
        return services;
    }

}
