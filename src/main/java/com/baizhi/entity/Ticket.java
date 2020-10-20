package com.baizhi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @author lvpeng
 * @description
 * @date 2020/10/19-16:06
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Accessors(chain = true)
public class Ticket {
    private String name;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date time;
    private String id;
    private String sex;
    private String departure;
    private String destination;
    private String flightNum;
    private String phone;
}
