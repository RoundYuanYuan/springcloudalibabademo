package com.roundyuan.fanggateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @program: springcloudalibabademo
 * @description:
 * @author: Mr.Zhangmy
 * @create: 2020-08-06 20:01
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class GateWayFang {
    public static void main(String[] args) {
        SpringApplication.run(GateWayFang.class,args);
    }
}
