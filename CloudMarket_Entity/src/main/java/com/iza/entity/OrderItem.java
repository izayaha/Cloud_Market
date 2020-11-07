package com.iza.entity;

import lombok.Data;

import java.util.Date;

/**
 * @program: CloudLike
 * @description:
 * @author: Feri(邢朋辉)
 * @create: 2020-11-05 10:20
 */
@Data
public class OrderItem {
    private Integer id;
    private Long oid;
    private Integer skuid;
    private Integer count;
    private Integer price;
    private Date ctime;
}
