package com.block.city.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.block.city.repository.entity.CompanyEntity;
import com.block.city.repository.tables.COMPANY;
import com.block.city.vo.Company;
import com.wxbc.base.util.BeanUtil;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.block.city.repository.mapper.CompanyDao;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.UUID;

/**
 * JDK         : 1.8
 * ProjectName : through-city
 * Author      : city
 * Date        : 2020-10-24 19:08:46
 * Description : auto generated service
 */
@Service
@Slf4j
public class CompanyService {

    @Autowired
    private CompanyDao companyDao;

    public boolean addCompany(Company company){
        CompanyEntity entity =new CompanyEntity();
        company.setId(null);
        BeanUtil.copyProperties(company, entity);
        entity.setAddress("0x" + UUID.randomUUID().toString().replace("-",""));
        entity.setPubKey(UUID.randomUUID().toString().replace("-", ""));

        companyDao.insert(entity);
        return true;
    }

    public List<Company> queryCompanyList(){
        QueryWrapper<CompanyEntity> query = new QueryWrapper<>();
        List<CompanyEntity> entityList = companyDao.selectList(query);
        return BeanUtil.copyList(entityList, Company::new);
    }

    public Company queryCompany(String name) {
        QueryWrapper<CompanyEntity> query = new QueryWrapper<>();
        query.like(COMPANY.NAME, name);
        List<CompanyEntity> entityList = companyDao.selectList(query);
        if (!CollectionUtils.isEmpty(entityList)) {
            Company company = new Company();
            BeanUtil.copyProperties(entityList.get(0), company);
            return company;
        }
        return null;
    }

    public boolean charge(Company company){
        CompanyEntity com = companyDao.selectById(company.getId());
        CompanyEntity entity = new CompanyEntity();
        entity.setId(com.getId());
        entity.setAmount(com.getAmount() + company.getAmount());
        return companyDao.updateById(entity) == 1;
    }
}
