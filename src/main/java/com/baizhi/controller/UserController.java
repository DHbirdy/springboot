package com.baizhi.controller;

import com.alibaba.druid.util.StringUtils;
import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import com.baizhi.vo.Result;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin  //解决跨域问题
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;


    //删除用户
    @GetMapping("delete")
    public Result deleteById(String id){
        Result result = new Result();
        try {
            userService.delete(id);
            result.setMsg("成功删除用户信息");
        } catch (Exception e) {
            e.printStackTrace();
            result.setStatus(false);
            result.setMsg("删除用户信息失败");
        }
        return result;
    }

        //保存或修改
    @PostMapping("saveOrUpdate")
    public Result saveOrUpdate(@RequestBody User user){
        Result result = new Result();
        Document document = creatDocument(user);
        try {
            writeDocument(document,user);
        } catch (IOException e) {
            result.setMsg("文件写入失败");
            result.setStatus(false);
        }
        try {
            //前端传入的对象参数有id说明是添加操作，否则是修改操作
            if(StringUtils.isEmpty(user.getId())) {
                userService.save(user);
                result.setMsg("用户信息保存成功");
            }else{
                userService.update(user);
                result.setMsg("用户信息编辑成功!!!");
            }
        } catch (Exception e) {
            result.setStatus(false);
            result.setMsg("用户信息保存失败");
        }
        return result;
    }
    //查询所有
    @GetMapping("findAll")
    @ResponseBody
    public List<User> findAll() {
        return userService.findAll();
    }


    //分页查询方法
    @GetMapping("findByPage")
    public Map<String,Object> findByPage(Integer pageNow,Integer pageSize){
        Map<String,Object> result = new HashMap<>();
        pageNow = pageNow==null?1:pageNow;
        pageSize = pageSize==null?4:pageSize;
        List<User> users = userService.findByPage(pageNow, pageSize);
        Long totals = userService.findTotals();
        result.put("users",users);
        result.put("total",totals);
        return result;
    }


    private Document creatDocument(User user){
        Document document = DocumentHelper.createDocument();
        Element root = document.addElement("root");
        Element user1 = root.addElement("User");
        user1.addAttribute("Id",user.getId());
        user1.addAttribute("Name",user.getName());
        user1.addAttribute("Sex",user.getSex());
        user1.addAttribute("Address",user.getAddress());
        user1.addAttribute("Birthday",user.getBir().toString());
        return document;
}

    private void writeDocument(Document document,User user) throws IOException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = simpleDateFormat.format(new Date());
        String path="D:/xml/"+date+user.getName()+".xml";
        FileWriter fileWriter = new FileWriter(path);
        document.write(fileWriter);
        fileWriter.close();
    }
}
