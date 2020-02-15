package com.qgw.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CfController {

    @Value("${info.profile}")
    private String env;

    @GetMapping("/info")
    public String configInfo() {
        return env;
    }
}
