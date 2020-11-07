package com.iza.pay.domain;

import lombok.Data;

/**
 * projectName:  CloudMarket
 *
 * @author: xuwei
 * time:  2020/11/6 14:40
 * description:
 */
@Data
public class AliPay {
    private double total_amount;
    private String out_trade_no;
    private String subject;
}
