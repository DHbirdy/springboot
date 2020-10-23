package com.baizhi.service;

import com.baizhi.entity.Ticket;

import java.util.List;

/**
 * @author lvpeng
 * @description
 * @date 2020/10/19-16:08
 */

public interface OrderService {
    //保存订单
    void saveOrder(Ticket ticket);

    //查询所有订单
    List<Ticket> findOrders();

    //删除订单
    void deleteOrder(String name);
}
