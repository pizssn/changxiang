package com.changgou.service;

import com.changgou.goods.pojo.Spec;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @Author: pizssn
 * @Description: com.changgou.service
 */
public interface SpecService {

    //Spec多条件分页查询
    PageInfo<Spec> findPage(Spec spec, int page, int size);

    //Spec分页查询
    PageInfo<Spec> findPage(int page, int size);

    //Spec多条件搜索方法
    List<Spec> findList(Spec spec);

    //删除Spec
    void delete(Integer id);

    //修改Spec数据
    void update(Spec spec);

    //新增Spec
    void add(Spec spec);

    //根据ID查询Spec
    Spec findById(Integer id);

    //查询所有Spec
    List<Spec> findAll();
}
