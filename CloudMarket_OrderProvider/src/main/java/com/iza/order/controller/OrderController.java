package com.iza.order.controller;

import com.iza.order.service.intf.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * projectName:  CloudMarket
 *
 * @author: xuwei
 * time:  2020/11/5 22:04
 * description:
 */
@RestController
public class OrderController {
    @Autowired
    private OrderService service;
}
