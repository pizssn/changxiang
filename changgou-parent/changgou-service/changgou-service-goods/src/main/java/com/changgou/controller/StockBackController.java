package com.changgou.controller;
import com.changgou.goods.pojo.StockBack;
import com.changgou.service.StockBackService;
import com.github.pagehelper.PageInfo;
import entity.Result;
import entity.StatusCode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


/**
 * @Author: pizssn
 * @Description: com.changgou
 */
@RestController
@RequestMapping("/stockBack")
@CrossOrigin
public class StockBackController {

    @Autowired
    private StockBackService stockBackService;

    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false)  StockBack stockBack, @PathVariable  int page, @PathVariable  int size){
        //调用StockBackService实现分页条件查询StockBack
        PageInfo<StockBack> pageInfo = stockBackService.findPage(stockBack, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用StockBackService实现分页查询StockBack
        PageInfo<StockBack> pageInfo = stockBackService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    @PostMapping(value = "/search" )
    public Result<List<StockBack>> findList(@RequestBody(required = false)  StockBack stockBack){
        //调用StockBackService实现条件查询StockBack
        List<StockBack> list = stockBackService.findList(stockBack);
        return new Result<List<StockBack>>(true,StatusCode.OK,"查询成功",list);
    }

    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable String id){
        //调用StockBackService实现根据主键删除
        stockBackService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    @PutMapping(value="/{id}")
    public Result update(@RequestBody  StockBack stockBack,@PathVariable String id){
        //设置主键值
        stockBack.setSkuId(id);
        //调用StockBackService实现修改StockBack
        stockBackService.update(stockBack);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    @PostMapping
    public Result add(@RequestBody   StockBack stockBack){
        //调用StockBackService实现添加StockBack
        stockBackService.add(stockBack);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    @GetMapping("/{id}")
    public Result<StockBack> findById(@PathVariable String id){
        //调用StockBackService实现根据主键查询StockBack
        StockBack stockBack = stockBackService.findById(id);
        return new Result<StockBack>(true,StatusCode.OK,"查询成功",stockBack);
    }

    @GetMapping
    public Result<List<StockBack>> findAll(){
        //调用StockBackService实现查询所有StockBack
        List<StockBack> list = stockBackService.findAll();
        return new Result<List<StockBack>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
