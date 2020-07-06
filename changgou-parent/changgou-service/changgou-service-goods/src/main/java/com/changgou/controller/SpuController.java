package com.changgou.controller;

import com.changgou.goods.pojo.Goods;
import com.changgou.goods.pojo.Spu;
import com.changgou.service.SpuService;
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
@RequestMapping("/spu")
@CrossOrigin
public class SpuController {

    @Autowired
    private SpuService spuService;

    @PostMapping(value = "/search/{page}/{size}")
    public Result<PageInfo> findPage(@RequestBody(required = false) Spu spu, @PathVariable int page, @PathVariable int size) {
        //调用SpuService实现分页条件查询Spu
        PageInfo<Spu> pageInfo = spuService.findPage(spu, page, size);
        return new Result(true, StatusCode.OK, "查询成功", pageInfo);
    }

    @GetMapping(value = "/search/{page}/{size}")
    public Result<PageInfo> findPage(@PathVariable int page, @PathVariable int size) {
        //调用SpuService实现分页查询Spu
        PageInfo<Spu> pageInfo = spuService.findPage(page, size);
        return new Result<PageInfo>(true, StatusCode.OK, "查询成功", pageInfo);
    }

    @PostMapping(value = "/search")
    public Result<List<Spu>> findList(@RequestBody(required = false) Spu spu) {
        //调用SpuService实现条件查询Spu
        List<Spu> list = spuService.findList(spu);
        return new Result<List<Spu>>(true, StatusCode.OK, "查询成功", list);
    }

    @DeleteMapping(value = "/{id}")
    public Result delete(@PathVariable Long id) {
        //调用SpuService实现根据主键删除
        spuService.delete(id);
        return new Result(true, StatusCode.OK, "删除成功");
    }

    @PutMapping(value = "/{id}")
    public Result update(@RequestBody Spu spu, @PathVariable Long id) {
        //设置主键值
        spu.setId(id);
        //调用SpuService实现修改Spu
        spuService.update(spu);
        return new Result(true, StatusCode.OK, "修改成功");
    }

    @PostMapping
    public Result add(@RequestBody Spu spu) {
        //调用SpuService实现添加Spu
        spuService.add(spu);
        return new Result(true, StatusCode.OK, "添加成功");
    }

    @GetMapping("/{id}")
    public Result<Spu> findById(@PathVariable Long id) {
        //调用SpuService实现根据主键查询Spu
        Spu spu = spuService.findById(id);
        return new Result<Spu>(true, StatusCode.OK, "查询成功", spu);
    }

    @GetMapping
    public Result<List<Spu>> findAll() {
        //调用SpuService实现查询所有Spu
        List<Spu> list = spuService.findAll();
        return new Result<List<Spu>>(true, StatusCode.OK, "查询成功", list);
    }

    @PostMapping("/save")
    public Result save(@RequestBody Goods goods) {
        spuService.save(goods);
        return new Result(true, StatusCode.OK, "保存商品成功", null);
    }

    //根据点击到的商品(SPU)的ID 获取到GOODS数据返回给页面展示
    @GetMapping("/goods/{id}")
    public Result<Goods> findGoodsById(@PathVariable(value = "id") Long id) {
        Goods goods = spuService.findGoodsById(id);
        return new Result<Goods>(true, StatusCode.OK, "查询goods数据成功", goods);
    }

    @PutMapping("/audit/{id}")
    public Result auditSpu(@PathVariable(name = "id") Long id) {
        spuService.auditSpu(id);
        return new Result(true, StatusCode.OK, "审核通过");
    }

    @PutMapping("/pull/{id}")
    public Result pullSpu(@PathVariable(name = "id") Long id) {
        spuService.pullSpu(id);
        return new Result(true, StatusCode.OK, "下架成功");
    }

    @DeleteMapping("/logic/delete/{id}")
    public Result logicDeleteSpu(@PathVariable(name = "id") Long id) {
        spuService.logicDeleteSpu(id);
        return new Result(true, StatusCode.OK, "逻辑删除成功");
    }

    @PutMapping("/restore/{id}")
    public Result restore(@PathVariable(name = "id") Long id) {
        spuService.restoreSpu(id);
        return new Result(true, StatusCode.OK, "还原成功");
    }
}
