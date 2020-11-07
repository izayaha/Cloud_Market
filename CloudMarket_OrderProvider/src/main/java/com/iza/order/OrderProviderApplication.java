package com.iza.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * projectName:  CloudMarket
 *
 * @author: xuwei
 * time:  2020/11/5 22:05
 * description:
 */
@SpringBootApplication
@MapperScan("com.iza.order.dao")
public class OrderProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderProviderApplication.class,args);
    }
}
