package com.roundyuan.ordermanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: springcloudalibabademo
 * @description:
 * @author: Mr.Zhangmy
 * @create: 2020-08-05 18:07
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class OrderManagerApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderManagerApplication.class, args);
    }
}
