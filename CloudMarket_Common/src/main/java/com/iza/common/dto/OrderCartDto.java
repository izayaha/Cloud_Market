package com.iza.common.dto;

import lombok.Data;

import java.util.List;

/**
 * @program: CloudLike
 * @description:
 * @author: Feri(邢朋辉)
 * @create: 2020-11-05 14:21
 */
@Data
public class OrderCartDto {
    private List<OrderGoodsDto> list;
    private int type;//标记位 1.立即购买 2.购物车
    private int uid;
    private int aid;//收货地址
    private Integer paytype;//支付方式
    private String skuids;//skuid-skuid

}
