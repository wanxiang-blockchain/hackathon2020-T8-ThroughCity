package com.block.city.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDate;

/**
 * JDK         : 1.8
 * ProjectName : through-city
 * Author      : chen cheng
 * Date        : 2020/10/24 下午6:59
 * Description :
 */
@Data
public class Company {

    @ApiModelProperty("id")
    private Long id;

    @ApiModelProperty("")
    private String name;

    @ApiModelProperty("积分")
    private Long amount;

    @ApiModelProperty("起租日期")
    private LocalDate rentStart;

    @ApiModelProperty("合同期限")
    private Integer rentYears;

    private String address;

    private String pubKey;
}
