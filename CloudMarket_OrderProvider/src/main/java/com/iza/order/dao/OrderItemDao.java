package com.iza.order.dao;

import java.util.Collection;

/**
 * @program: CloudLike
 * @description:
 * @author: Feri(邢朋辉)
 * @create: 2020-11-05 10:22
 */
public interface OrderItemDao {
    int[] insertBatch(Collection<Object> list);
}
