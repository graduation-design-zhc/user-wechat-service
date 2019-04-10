package com.user.wechat.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zhanghuachang
 * @date 2019-04-09
 */
@SpringBootApplication
@EnableEurekaClient
public class MainApplication {

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
        System.out.println(new SimpleDateFormat("[yyyy-MM-dd HH:mm:ss]").format(new Date()) + "user-wechat-service started!!!");
    }

}
