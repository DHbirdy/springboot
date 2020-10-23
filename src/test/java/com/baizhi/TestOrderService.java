package com.baizhi;

import com.baizhi.entity.Ticket;
import com.baizhi.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;


/**
 * @author lvpeng
 * @description
 * @date 2020/10/19-17:47
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestOrderService {

    @Autowired
    private OrderService orderService;

    @Test
    public void testSaveOrder(){
        Ticket ticket = new Ticket();
        ticket.setName("zhangsan");
        ticket.setId("123456");
        ticket.setDeparture("中国");
        ticket.setDestination("日本");
        ticket.setFlightNum("123");
        ticket.setPhone("123");
        ticket.setSex("男");
        ticket.setTime(new Date());

        orderService.saveOrder(ticket);
    }

    @Test
    public void testFindOrders(){
        List<Ticket> orders = orderService.findOrders();
        for(Ticket ticket: orders){
            System.out.println(ticket);
        }

    }

    @Test
    public void testDeleteOrder(){
        orderService.deleteOrder("zhangsan");
    }
}
