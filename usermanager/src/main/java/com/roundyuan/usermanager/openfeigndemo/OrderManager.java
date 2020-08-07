package com.roundyuan.usermanager.openfeigndemo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Component
@FeignClient("ordermanager")
public interface OrderManager {
    @RequestMapping("/user")
    public String getConfig();
}
