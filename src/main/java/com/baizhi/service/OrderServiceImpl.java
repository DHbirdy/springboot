package com.baizhi.service;

import com.baizhi.dao.OrderDao;
import com.baizhi.entity.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author lvpeng
 * @description
 * @date 2020/10/19-17:09
 */
@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;



    @Override
    public void saveOrder(Ticket ticket) {
        orderDao.saveOrder(ticket);
    }

    @Override
    public List<Ticket> findOrders() {
        return orderDao.findOrders();
    }

    @Override
    public void deleteOrder(String name) {
        orderDao.deleteOrder(name);
    }
}
