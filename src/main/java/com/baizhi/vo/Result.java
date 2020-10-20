package com.baizhi.vo;

import lombok.Data;

@Data
public class Result {
    //状态信息
    private Boolean status = true;

    //提示消息
    private String msg;
}
