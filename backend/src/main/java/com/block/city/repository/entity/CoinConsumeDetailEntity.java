package com.block.city.repository.entity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

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
@TableName("coin_consume_detail")
public class CoinConsumeDetailEntity {

    /**
     * primary key
     */
    @TableId(value = "id", type = IdType.ID_WORKER)
    private Long id;

    /**
     * 积分来源公司id
     */
    @TableField("from_company_id")
    private Long fromCompanyId;

    /**
     * 积分目标公司id
     */
    @TableField("to_company_id")
    private Long toCompanyId;

    /**
     * 消费数量
     */
    @TableField("amount")
    private Long amount;

    /**
     * 
     */
    @TableField("remark")
    private String remark;

    /**
     * 消费时间
     */
    @TableField("create_time")
    private LocalDateTime createTime;

}