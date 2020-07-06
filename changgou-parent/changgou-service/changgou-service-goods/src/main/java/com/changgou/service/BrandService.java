package com.changgou.service;

import com.changgou.goods.pojo.Brand;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @Author: pizssn
 * @Description: com.changgou.service
 */
public interface BrandService {
    List<Brand> findAll();

    Brand findById(Integer id);

    void add(Brand brand);

    void updateById(Brand brand);

    void deleteById(Integer id);

    List<Brand> findList(Brand brand);

    //PageInfo是自动分页工具pagehelper下的
    PageInfo<Brand> findPage(Integer page, Integer size);

    PageInfo<Brand> findPage(Brand brand, Integer page, Integer size);
}
