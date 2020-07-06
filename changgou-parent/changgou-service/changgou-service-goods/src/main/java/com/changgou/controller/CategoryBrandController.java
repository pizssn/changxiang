package com.changgou.controller;
import com.changgou.goods.pojo.CategoryBrand;
import com.changgou.service.CategoryBrandService;
import com.github.pagehelper.PageInfo;
import entity.Result;
import entity.StatusCode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


/**
 * @Author: pizssn
 * @Description: com.changgou.controller
 */
@RestController
@RequestMapping("/categoryBrand")
@CrossOrigin
public class CategoryBrandController {

    @Autowired
    private CategoryBrandService categoryBrandService;

    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false)  CategoryBrand categoryBrand, @PathVariable  int page, @PathVariable  int size){
        //调用CategoryBrandService实现分页条件查询CategoryBrand
        PageInfo<CategoryBrand> pageInfo = categoryBrandService.findPage(categoryBrand, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用CategoryBrandService实现分页查询CategoryBrand
        PageInfo<CategoryBrand> pageInfo = categoryBrandService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    @PostMapping(value = "/search" )
    public Result<List<CategoryBrand>> findList(@RequestBody(required = false)  CategoryBrand categoryBrand){
        //调用CategoryBrandService实现条件查询CategoryBrand
        List<CategoryBrand> list = categoryBrandService.findList(categoryBrand);
        return new Result<List<CategoryBrand>>(true,StatusCode.OK,"查询成功",list);
    }

    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Integer id){
        //调用CategoryBrandService实现根据主键删除
        categoryBrandService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    @PutMapping(value="/{id}")
    public Result update(@RequestBody  CategoryBrand categoryBrand,@PathVariable Integer id){
        //设置主键值
        categoryBrand.setCategoryId(id);
        //调用CategoryBrandService实现修改CategoryBrand
        categoryBrandService.update(categoryBrand);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    @PostMapping
    public Result add(@RequestBody   CategoryBrand categoryBrand){
        //调用CategoryBrandService实现添加CategoryBrand
        categoryBrandService.add(categoryBrand);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    @GetMapping("/{id}")
    public Result<CategoryBrand> findById(@PathVariable Integer id){
        //调用CategoryBrandService实现根据主键查询CategoryBrand
        CategoryBrand categoryBrand = categoryBrandService.findById(id);
        return new Result<CategoryBrand>(true,StatusCode.OK,"查询成功",categoryBrand);
    }

    @GetMapping
    public Result<List<CategoryBrand>> findAll(){
        //调用CategoryBrandService实现查询所有CategoryBrand
        List<CategoryBrand> list = categoryBrandService.findAll();
        return new Result<List<CategoryBrand>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
