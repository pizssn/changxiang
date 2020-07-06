package com.changgou.service;

import com.changgou.goods.pojo.Template;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @Author: pizssn
 * @Description: com.changgou.service
 */
public interface TemplateService {

    //Template多条件分页查询
    PageInfo<Template> findPage(Template template, int page, int size);

    //Template分页查询
    PageInfo<Template> findPage(int page, int size);

    //Template多条件搜索方法
    List<Template> findList(Template template);

    //删除Template
    void delete(Integer id);

    //修改Template数据
    void update(Template template);

    //新增Template
    void add(Template template);

    //根据ID查询Template
    Template findById(Integer id);

    //查询所有Template
    List<Template> findAll();
}
