package com.iza.order.service.intf;

import com.iza.common.dto.OrderCartDto;
import com.iza.common.vo.R;

public interface OrderService {
    R order(OrderCartDto dto);
    //1.超时订单 2.Redis 3.同步到Mysql
    R orderV2(OrderCartDto dto);
    //我的订单
    R queryByUid(int uid);
}
