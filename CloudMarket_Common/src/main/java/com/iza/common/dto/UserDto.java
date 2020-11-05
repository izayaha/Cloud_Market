package com.iza.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * projectName:  CloudMarket
 *
 * @author: xuwei
 * time:  2020/11/5 19:30
 * description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private String account;
    private String pasword;
}
