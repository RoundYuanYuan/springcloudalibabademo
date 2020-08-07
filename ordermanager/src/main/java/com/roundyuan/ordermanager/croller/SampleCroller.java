package com.roundyuan.ordermanager.croller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: springcloudalibabademo
 * @description:
 * @author: Mr.Zhangmy
 * @create: 2020-08-05 19:41
 **/
@RestController
@RefreshScope
public class SampleCroller {
    @Value("${user.name}")
    String userName;
    @Value("${user.age}")
    int age;

    @RequestMapping("/user")
    public String simple() {
        return "Hello Nacos Config!" + "Hello " + userName + " " + age ;
    }

}
