package com.qgw.controller;

import com.qgw.service.DcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DcController {

    @Autowired
    DcService dcService;

    @GetMapping("/consumer")
    public String dc() {
        return dcService.consumer();
    }
}
