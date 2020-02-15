package com.qgw.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

//DcClient的接口消费的服务名称
@FeignClient("eureka-client-provider")
public interface DcClient {

    //服务的某个接口
    @GetMapping("/dc")
    String consumer();
}
