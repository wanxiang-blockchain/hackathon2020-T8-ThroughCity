package com.block.city.vo;

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
    private Long id;

    /**
     * 活动名称
     */
    private String name;

    /**
     * 积分
     */
    private Long amount;



    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 公司名称
     */
    private String companyName;

    /**
     * 活动地点
     */
    private String address;

    /**
     *
     */
    private String content;

    private LocalDate startDate;

    /**
     *
     */
    private LocalDate endDate;
}
