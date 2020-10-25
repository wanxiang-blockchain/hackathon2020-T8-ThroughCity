package com.block.city.controller;

import com.block.city.service.CompanyService;
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
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @ApiOperation("增加公司")
    @PostMapping("/company/add")
    public BaseResponse<Boolean> addCompany(@RequestBody  Company company){
        boolean b = companyService.addCompany(company);
        return ResponseFormat.success(b);
    }

    @ApiOperation("查询公司列表")
    @PostMapping("/company/list")
    public BaseResponse<List<Company>> queryCompany(){
        List<Company> list = companyService.queryCompanyList();
        return ResponseFormat.success(list);
    }

    @ApiOperation("查询公司信息")
    @PostMapping("/company/query-by-name")
    public BaseResponse<Company> queryCompany(@RequestBody Company c){
        Company company = companyService.queryCompany(c.getName());
        return ResponseFormat.success(company);
    }

}