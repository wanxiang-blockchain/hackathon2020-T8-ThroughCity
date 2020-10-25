package com.block.city.vo;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * JDK         : 1.8
 * ProjectName : through-city
 * Author      : chen cheng
 * Date        : 2020/10/24 下午7:03
 * Description :
 */
@Data
public class CoinConsumeDetail {

    private Long id;

    private Long fromCompanyId;

    private Long toCompanyId;

    private Long amount;

    private String remark;

    private LocalDateTime createTime;

}
