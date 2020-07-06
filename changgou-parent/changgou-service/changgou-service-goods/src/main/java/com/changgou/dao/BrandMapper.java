package com.changgou.dao;

import com.changgou.goods.pojo.Brand;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/**
 * @Author: pizssn
 * @Description: com.changgou.dao
 * 通用Mapper封装了增删改查的SQL语句，直接调用即可
 */
@Repository
public interface BrandMapper extends Mapper<Brand> {
}
