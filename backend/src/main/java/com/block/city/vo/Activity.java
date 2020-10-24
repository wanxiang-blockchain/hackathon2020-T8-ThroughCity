package com.block.city.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * JDK         : 1.8
 * ProjectName : through-city
 * Author      : chen cheng
 * Date        : 2020/10/24 下午9:50
 * Description :
 */
@Data
public class Activity {

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

    private LocalDate startDate;

    /**
     *
     */
    @TableField("end_date")
    private LocalDate endDate;
}
