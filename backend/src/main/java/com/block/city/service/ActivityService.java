package com.block.city.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.block.city.repository.entity.ActivityEntity;
import com.block.city.vo.Activity;
import com.wxbc.base.util.BeanUtil;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.block.city.repository.mapper.ActivityDao;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * JDK         : 1.8
 * ProjectName : through-city
 * Author      : city
 * Date        : 2020-10-24 21:48:11
 * Description : auto generated service
 */
@Service
@Slf4j
public class ActivityService {

    @Autowired
    private ActivityDao activityDao;

    public  boolean addActivity(Activity activity){
        ActivityEntity entity = new ActivityEntity();
        activity.setId(null);
        BeanUtil.copyProperties(activity, entity);
        return activityDao.insert(entity) == 1;
    }

    public List<Activity> queryActivity(){
        QueryWrapper<ActivityEntity> query = new QueryWrapper<>();
        List<ActivityEntity> entityList = activityDao.selectList(query);
        return BeanUtil.copyList(entityList, Activity::new);
    }
}
