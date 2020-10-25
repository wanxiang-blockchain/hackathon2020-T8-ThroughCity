package com.block.city.repository.entity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Data;


/**
 * JDK         : 1.8
 * ProjectName : through-city
 * Author      : city
 * Date        : 2020-10-24 21:59:04
 * Description : auto generated entity
 */
@Data
@TableName("activity")
public class ActivityEntity {

    /**
     * primary
     */
    @TableId(value = "id", type = IdType.ID_WORKER)
    private Long id;

    /**
     * 活动名称
     */
    @TableField("name")
    private String name;

    /**
     * 积分
     */
    @TableField("amount")
    private Long amount;

    /**
     * 
     */
    @TableField("start_date")
    private LocalDate startDate;

    /**
     * 
     */
    @TableField("end_date")
    private LocalDate endDate;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private LocalDateTime createTime;

    /**
     * 公司名称
     */
    @TableField("company_name")
    private String companyName;

    /**
     * 活动地点
     */
    @TableField("address")
    private String address;

    /**
     * 
     */
    @TableField("content")
    private String content;

}