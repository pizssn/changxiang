package com.changgou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @Author: pizssn
 * @Description: com.changgou
 */
@SpringBootApplication
@EnableEurekaClient //开启Eureka客户端
@MapperScan(basePackages = {"com.changgou.dao"}) //开启通用Mapper的包扫描
public class GoodsApplication {
    public static void main(String[] args) {
        SpringApplication.run(GoodsApplication.class,args);
    }
}
