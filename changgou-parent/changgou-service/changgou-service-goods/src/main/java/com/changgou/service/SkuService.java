package com.changgou.service;

import com.changgou.goods.pojo.Sku;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @Author: pizssn
 * @Description: com.changgou.service
 */
public interface SkuService {

    PageInfo<Sku> findPage(Sku sku, int page, int size);

    PageInfo<Sku> findPage(int page, int size);

    List<Sku> findList(Sku sku);

    void delete(Long id);

    void update(Sku sku);

    void add(Sku sku);

    Sku findById(Long id);

    List<Sku> findAll();
}
