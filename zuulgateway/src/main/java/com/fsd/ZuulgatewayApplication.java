package com.fsd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy // 开启zuul代理
public class ZuulgatewayApplication {
    public static void main(String[] args) {
       SpringApplication.run(ZuulgatewayApplication.class,args);
    }
}
