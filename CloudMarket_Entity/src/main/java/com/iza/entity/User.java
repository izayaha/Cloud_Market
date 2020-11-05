package com.iza.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * projectName:  CloudMarket
 *
 * @author: xuwei
 * time:  2020/11/5 19:27
 * description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer id;
    private String account;
    private String password;
}
