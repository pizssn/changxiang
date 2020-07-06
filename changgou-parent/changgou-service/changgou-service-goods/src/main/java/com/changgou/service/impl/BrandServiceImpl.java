package com.changgou.service.impl;

import com.changgou.dao.BrandMapper;
import com.changgou.goods.pojo.Brand;
import com.changgou.service.BrandService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;

import java.util.List;

/**
 * @Author: pizssn
 * @Description: com.changgou.service.impl
 */
@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandMapper brandMapper;

    @Override
    public List<Brand> findAll() {
        return brandMapper.selectAll();
    }

    @Override
    public Brand findById(Integer id) {
        return brandMapper.selectByPrimaryKey(id);
    }

    //Selective是表示会忽略为NULL的值
    @Override
    public void add(Brand brand) {
        brandMapper.insertSelective(brand);
    }

    @Override
    public void updateById(Brand brand) {
        brandMapper.updateByPrimaryKeySelective(brand);
    }

    @Override
    public void deleteById(Integer id) {
        brandMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Brand> findList(Brand brand) {
        //调用方法构造条件
        Example example = creatExample(brand);
        return brandMapper.selectByExample(example);
    }

    @Override
    public PageInfo<Brand> findPage(Integer page, Integer size) {
        //分页实现 PageHelper.startPage(page,size);后面必须紧跟集合查询
        PageHelper.startPage(page,size);
        List<Brand> brands = brandMapper.selectAll();
        //封装PageInfo
        return new PageInfo<>(brands);
    }

    @Override
    public PageInfo<Brand> findPage(Brand brand, Integer page, Integer size) {
        PageHelper.startPage(page,size);
        List<Brand> brands = brandMapper.selectByExample(creatExample(brand));
        return new PageInfo<>(brands);
    }

    //把条件查询抽取出来，作为一个公共类
    public Example creatExample(Brand brand){
        //自定义搜索对象Example
        Example example = new Example(Brand.class);
        Example.Criteria criteria = example.createCriteria();//条件构造器
        if (null!=brand){
            if (!StringUtil.isEmpty(brand.getName())){
                //(Brand的属性名，搜索的条件)
                criteria.andLike("name","%"+brand.getName()+"%");
            }
            if (!StringUtil.isEmpty(brand.getLetter())){
                criteria.andEqualTo("letter",brand.getLetter());
            }
        }
        return example;
    }
}
