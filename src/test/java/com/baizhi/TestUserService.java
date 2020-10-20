package com.baizhi;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
public class TestUserService {

    @Autowired
    private UserService userService;


    @Test
    public void testDelete(){
        userService.delete("6");
    }

    @Test
    public void testSave(){
        User user = new User();
        user.setName("丸子");
        user.setBir(new Date());
        user.setSex("男");
        user.setAddress("日本东爱媛");
        userService.save(user);
    }

    @Test
    public void testFindAll(){
        userService.findAll().forEach(user-> System.out.println("user = " + user));
    }
}
