package com.iza.login.controller;


import com.iza.common.dto.UserDto;
import com.iza.common.vo.R;
import com.iza.login.service.intf.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * projectName:  CloudMarket
 *
 * @author: xuwei
 * time:  2020/11/5 19:21
 * description:
 */
@RestController
public class LoginController {
    @Autowired
    private LoginService service;

    @PostMapping("/user/login.do")
    public R login(UserDto dto){
        return service.login(dto);
    }

}
