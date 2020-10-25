package com.block.city;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
* JDK         : 1.8
* ProjectName : through-city
* Author      : city
* Date        : 2020-10-24 06:56:33
* Description : auto generated
*/
@MapperScan(basePackages = "com.block.city.repository.mapper")
@SpringBootApplication(scanBasePackages = {"com.wxbc","com.block"})
public class CityApplication {

    public static void main(String[] args) {
        SpringApplication.run(CityApplication.class, args);
    }
}