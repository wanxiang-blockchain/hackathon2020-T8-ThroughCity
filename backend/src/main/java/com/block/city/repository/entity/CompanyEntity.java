package com.block.city.repository.entity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.time.LocalDate;

import lombok.Data;


/**
 * JDK         : 1.8
 * ProjectName : through-city
 * Author      : city
 * Date        : 2020-10-24 21:09:53
 * Description : auto generated entity
 */
@Data
@TableName("company")
public class CompanyEntity {

    /**
     * primary
     */
    @TableId(value = "id", type = IdType.ID_WORKER)
    private Long id;

    /**
     * 企业名称
     */
    @TableField("name")
    private String name;

    /**
     * 积分余额
     */
    @TableField("amount")
    private Long amount;

    /**
     * 起租日期
     */
    @TableField("rent_start")
    private LocalDate rentStart;

    /**
     * 合同时长
     */
    @TableField("rent_years")
    private Integer rentYears;

    /**
     * 地址
     */
    @TableField("address")
    private String address;

    /**
     * 公钥
     */
    @TableField("pub_key")
    private String pubKey;

}