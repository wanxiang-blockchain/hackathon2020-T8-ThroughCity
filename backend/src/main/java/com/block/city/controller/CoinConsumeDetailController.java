package com.block.city.controller;

import com.block.city.service.CoinConsumeDetailService;
import com.block.city.vo.CoinConsumeDetail;
import com.block.city.vo.Company;
import com.wxbc.base.annotations.WxAppController;
import com.wxbc.scaffold.common.definition.response.BaseResponse;
import com.wxbc.scaffold.common.definition.response.ResponseFormat;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * JDK         : 1.8
 * ProjectName : through-city
 * Author      : city
 * Date        : 2020-10-24 19:06:39
 * Description : auto generated controller
 */
@Slf4j
@CrossOrigin("*")
@WxAppController("/api/v1/city")
public class CoinConsumeDetailController {

    @Autowired
    private CoinConsumeDetailService coinConsumeDetailService;

    @ApiOperation("积分消费转账")
    @PostMapping("/coin/consume")
    public BaseResponse<Boolean> consumeCoin(@RequestBody CoinConsumeDetail detail){
        boolean b = coinConsumeDetailService.consumeCoin(detail);
        return ResponseFormat.success(b);
    }

    @ApiOperation("查询消费列表")
    @PostMapping("/coin/list-by-id")
    public BaseResponse<List<CoinConsumeDetail>> queryConsumeList(@RequestBody Long id){
        List<CoinConsumeDetail> list = coinConsumeDetailService.queryList(id);
        return ResponseFormat.success(list);
    }

    @ApiOperation("积分充值")
    @PostMapping("/coin/charge")
    public BaseResponse<Boolean> charge(@RequestBody Company company){

        boolean charge = coinConsumeDetailService.charge(company);
        return ResponseFormat.success(charge);
    }
}