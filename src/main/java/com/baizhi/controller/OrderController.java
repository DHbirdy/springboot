package com.baizhi.controller;

import com.baizhi.entity.Ticket;
import com.baizhi.service.OrderService;
import com.baizhi.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author lvpeng
 * @description
 * @date 2020/10/19-17:02
 */
@RestController
@CrossOrigin
@RequestMapping("/reserve")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("saveOrder")
    public Result saveOrder(@RequestBody Ticket ticket){
        Result result = new Result();
        try {
            orderService.saveOrder(ticket);
            result.setMsg("用户信息保存成功");
            return null;
        } catch (Exception e) {
            result.setStatus(false);
            result.setMsg("订单保存失败");
        }
        return result;
    }

    @GetMapping("findOrders")
    @ResponseBody
    public List<Ticket> findOrders(){
        return orderService.findOrders();
    }

    @GetMapping("deleteOrder")
    public Result deleteOrder(String name){
        Result result = new Result();
        try {
            orderService.deleteOrder(name);
            result.setMsg("成功删除订单信息");
        } catch (Exception e) {
            e.printStackTrace();
            result.setStatus(false);
            result.setMsg("删除订单信息失败");
        }
        return result;
    }
}
