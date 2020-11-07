package com.iza.order.config;

/**
 * @program: CloudLike
 * @description:
 * @author: Feri(邢朋辉)
 * @create: 2020-11-05 14:34
 */
public enum OrderType {
    待支付(1),待发货(2),待签收(3),待确认(4),待评价(5),已评价(6),取消订单(7),超时订单(8);
    private int val;
    private OrderType(int v){
        val=v;
    }

    public int getVal() {
        return val;
    }
}
