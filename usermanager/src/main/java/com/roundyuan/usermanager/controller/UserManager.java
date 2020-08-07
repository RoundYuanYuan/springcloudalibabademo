package com.roundyuan.usermanager.controller;

import com.roundyuan.usermanager.openfeigndemo.OrderManager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @program: springcloudalibabademo
 * @description:
 * @author: Mr.Zhangmy
 * @create: 2020-08-06 17:00
 **/
@RestController
public class UserManager {
    @Resource
    private OrderManager orderManager;

    @RequestMapping("getConfig")
    public String getConfig(){
        String config = orderManager.getConfig();
        return config;
    }

}
