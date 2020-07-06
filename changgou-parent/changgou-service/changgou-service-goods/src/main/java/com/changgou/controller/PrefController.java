package com.changgou.controller;
import com.changgou.goods.pojo.Pref;
import com.changgou.service.PrefService;
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
@RequestMapping("/pref")
@CrossOrigin
public class PrefController {

    @Autowired
    private PrefService prefService;

    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false)  Pref pref, @PathVariable  int page, @PathVariable  int size){
        //调用PrefService实现分页条件查询Pref
        PageInfo<Pref> pageInfo = prefService.findPage(pref, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用PrefService实现分页查询Pref
        PageInfo<Pref> pageInfo = prefService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    @PostMapping(value = "/search" )
    public Result<List<Pref>> findList(@RequestBody(required = false)  Pref pref){
        //调用PrefService实现条件查询Pref
        List<Pref> list = prefService.findList(pref);
        return new Result<List<Pref>>(true,StatusCode.OK,"查询成功",list);
    }

    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Integer id){
        //调用PrefService实现根据主键删除
        prefService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    @PutMapping(value="/{id}")
    public Result update(@RequestBody  Pref pref,@PathVariable Integer id){
        //设置主键值
        pref.setId(id);
        //调用PrefService实现修改Pref
        prefService.update(pref);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    @PostMapping
    public Result add(@RequestBody   Pref pref){
        //调用PrefService实现添加Pref
        prefService.add(pref);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    @GetMapping("/{id}")
    public Result<Pref> findById(@PathVariable Integer id){
        //调用PrefService实现根据主键查询Pref
        Pref pref = prefService.findById(id);
        return new Result<Pref>(true,StatusCode.OK,"查询成功",pref);
    }

    @GetMapping
    public Result<List<Pref>> findAll(){
        //调用PrefService实现查询所有Pref
        List<Pref> list = prefService.findAll();
        return new Result<List<Pref>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
