package com.baizhi.dao;

import com.baizhi.entity.Ticket;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author lvpeng
 * @description
 * @date 2020/10/19-17:06
 */
@Mapper
public interface OrderDao {

    //提交订单
    void saveOrder(Ticket ticket);

    //查询所有订单
    List<Ticket> findOrders();

    //根据姓名删除订单
    void deleteOrder(String name);

}
