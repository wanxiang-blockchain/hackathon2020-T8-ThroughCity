package com.block.city.service;

import com.baomidou.mybatisplus.core.conditions.query.Query;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.block.city.repository.entity.CoinConsumeDetailEntity;
import com.block.city.repository.entity.CompanyEntity;
import com.block.city.repository.tables.COIN_CONSUME_DETAIL;
import com.block.city.vo.CoinConsumeDetail;
import com.block.city.vo.Company;
import com.wxbc.base.util.BeanUtil;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.block.city.repository.mapper.CoinConsumeDetailDao;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.List;

/**
 * JDK         : 1.8
 * ProjectName : through-city
 * Author      : city
 * Date        : 2020-10-24 19:08:46
 * Description : auto generated service
 */
@Service
@Slf4j
public class CoinConsumeDetailService {

    @Autowired
    private CoinConsumeDetailDao coinConsumeDetailDao;

    @Autowired
    private CompanyService companyService;

    public boolean consumeCoin(CoinConsumeDetail detail){
        CoinConsumeDetailEntity entity = new CoinConsumeDetailEntity();
        BeanUtil.copyProperties(detail, entity);
        coinConsumeDetailDao.insert(entity);
        return true;
    }

    public List<CoinConsumeDetail> queryList(Long id){
        QueryWrapper<CoinConsumeDetailEntity> query = new QueryWrapper<>();
        query.eq(COIN_CONSUME_DETAIL.FROM_COMPANY_ID, id).or(q->q.eq(COIN_CONSUME_DETAIL.TO_COMPANY_ID, id));
        List<CoinConsumeDetailEntity> entityList = coinConsumeDetailDao.selectList(query);
        return BeanUtil.copyList(entityList, CoinConsumeDetail::new);
    }

    public boolean charge(Company company){
        companyService.charge(company);
        CoinConsumeDetailEntity entity = new CoinConsumeDetailEntity();
        entity.setFromCompanyId(0L);
        entity.setToCompanyId(company.getId());
        entity.setAmount(company.getAmount());
        entity.setRemark("充值");
        entity.setCreateTime(LocalDateTime.now());
        //充值上链，
        //积分上链
        return coinConsumeDetailDao.insert(entity) == 1;
    }
}
