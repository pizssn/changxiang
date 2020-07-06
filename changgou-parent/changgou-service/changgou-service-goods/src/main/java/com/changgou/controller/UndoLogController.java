package com.changgou.controller;
import com.changgou.goods.pojo.UndoLog;
import com.changgou.service.UndoLogService;
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
@RequestMapping("/undoLog")
@CrossOrigin
public class UndoLogController {

    @Autowired
    private UndoLogService undoLogService;

    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false)  UndoLog undoLog, @PathVariable  int page, @PathVariable  int size){
        //调用UndoLogService实现分页条件查询UndoLog
        PageInfo<UndoLog> pageInfo = undoLogService.findPage(undoLog, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用UndoLogService实现分页查询UndoLog
        PageInfo<UndoLog> pageInfo = undoLogService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    @PostMapping(value = "/search" )
    public Result<List<UndoLog>> findList(@RequestBody(required = false)  UndoLog undoLog){
        //调用UndoLogService实现条件查询UndoLog
        List<UndoLog> list = undoLogService.findList(undoLog);
        return new Result<List<UndoLog>>(true,StatusCode.OK,"查询成功",list);
    }

    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Long id){
        //调用UndoLogService实现根据主键删除
        undoLogService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    @PutMapping(value="/{id}")
    public Result update(@RequestBody  UndoLog undoLog,@PathVariable Long id){
        //设置主键值
        undoLog.setId(id);
        //调用UndoLogService实现修改UndoLog
        undoLogService.update(undoLog);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    @PostMapping
    public Result add(@RequestBody   UndoLog undoLog){
        //调用UndoLogService实现添加UndoLog
        undoLogService.add(undoLog);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    @GetMapping("/{id}")
    public Result<UndoLog> findById(@PathVariable Long id){
        //调用UndoLogService实现根据主键查询UndoLog
        UndoLog undoLog = undoLogService.findById(id);
        return new Result<UndoLog>(true,StatusCode.OK,"查询成功",undoLog);
    }

    @GetMapping
    public Result<List<UndoLog>> findAll(){
        //调用UndoLogService实现查询所有UndoLog
        List<UndoLog> list = undoLogService.findAll();
        return new Result<List<UndoLog>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
