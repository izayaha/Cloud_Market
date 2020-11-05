package com.iza.login;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * projectName:  CloudMarket
 *
 * @author: xuwei
 * time:  2020/11/5 19:18
 * description:
 */
@SpringBootApplication
@MapperScan("com.iza.login.dao")
public class LoginApplication {
    public static void main(String[] args) {
        SpringApplication.run(LoginApplication.class,args);
    }
}
