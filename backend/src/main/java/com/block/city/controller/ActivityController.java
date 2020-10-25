package com.block.city.controller;

import com.block.city.vo.Activity;
import com.wxbc.base.annotations.WxAppController;
import com.wxbc.scaffold.common.definition.response.BaseResponse;
import com.wxbc.scaffold.common.definition.response.ResponseFormat;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;

import com.block.city.service.ActivityService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * JDK         : 1.8
 * ProjectName : through-city
 * Author      : city
 * Date        : 2020-10-24 21:48:07
 * Description : auto generated controller
 */
@Slf4j
@CrossOrigin("*")
@WxAppController("/api/v1/city")
public class ActivityController{

	@Autowired
	private ActivityService activityService;

	@ApiOperation("增加活动")
	@PostMapping("/activity/add")
	public BaseResponse<Boolean> addActivity(@RequestBody Activity activity){
		boolean b = activityService.addActivity(activity);
		return ResponseFormat.success(b);
	}

	@ApiOperation("查询活动列表")
	@PostMapping("/activity/list")
	public BaseResponse<List<Activity>> list(){
		List<Activity> list = activityService.queryActivity();
		return ResponseFormat.success(list);
	}
}