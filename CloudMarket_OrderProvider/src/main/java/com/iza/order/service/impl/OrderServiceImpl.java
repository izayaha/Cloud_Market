package com.iza.order.service.impl;

import com.iza.common.dto.OrderCartDto;
import com.iza.common.util.IdGeneratorSinglon;
import com.iza.common.vo.R;
import com.iza.entity.Order;
import com.iza.order.service.intf.OrderService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * projectName:  CloudMarket
 *
 * @author: xuwei
 * time:  2020/11/5 21:59
 * description:
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Override
    public R order(OrderCartDto dto) {
        //下单接口
        //校验
        if (dto != null) {
            if (dto.getUid()>0 && dto.getAid()>0 && dto.getSkuids()!=null) {
                //计算
                List<Object> list = new ArrayList<>();
                Order order = new Order();
                order.setId(IdGeneratorSinglon.getInstance().generator.nextId());
                int t =0;
            }
        }
        return null;
    }

    @Override
    public R orderV2(OrderCartDto dto) {
        return null;
    }

    @Override
    public R queryByUid(int uid) {
        return null;
    }
}
