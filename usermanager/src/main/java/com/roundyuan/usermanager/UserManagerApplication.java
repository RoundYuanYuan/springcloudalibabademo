package com.roundyuan.usermanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @program: springcloudalibabademo
 * @description:
 * @author: Mr.Zhangmy
 * @create: 2020-08-05 19:20
 **/
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class UserManagerApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserManagerApplication.class,args);
    }
}
