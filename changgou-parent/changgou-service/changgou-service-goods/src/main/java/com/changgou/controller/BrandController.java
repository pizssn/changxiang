package com.changgou.controller;

import com.changgou.goods.pojo.Brand;
import com.changgou.service.BrandService;
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
@RequestMapping("/brand")
@CrossOrigin //跨域
public class BrandController {
    @Autowired
    private BrandService brandService;

    //相应结果封装
    @GetMapping
    public Result<List<Brand>> findAll() {
        List<Brand> brands = brandService.findAll();
        return new Result<>(true, StatusCode.OK, "查询品牌集合成功！", brands);
    }

    @GetMapping("/{id}")
    public Result<Brand> findById(@PathVariable("id") Integer id) {
        return new Result<>(true, StatusCode.OK, "根据ID查询品牌成功!", brandService.findById(id));
    }

    @PostMapping
    public Result add(@RequestBody Brand brand) {
        brandService.add(brand);
        return new Result(true, StatusCode.OK, "新增品牌成功！");
    }

    @PutMapping("/{id}")
    public Result updateById(@PathVariable("id") Integer id, @RequestBody Brand brand) {
        //设置要修改的品牌ID
        brand.setId(id);
        brandService.updateById(brand);
        return new Result(true, StatusCode.OK, "修改品牌成功！");
    }

    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable("id") Integer id) {
        brandService.deleteById(id);
        return new Result(true, StatusCode.OK, "删除品牌成功！");
    }

    @PostMapping("/search")
    public Result<List<Brand>> findList(@RequestBody Brand brand) {
        List<Brand> list = brandService.findList(brand);
        return new Result<>(true, StatusCode.OK, "条件查询成功！", list);
    }

    @GetMapping("/search/{page}/{size}")
    public Result<PageInfo<Brand>> findPage(@PathVariable("page") Integer page, @PathVariable("size") Integer size) {
        PageInfo<Brand> pageInfo = brandService.findPage(page, size);
        return new Result<>(true, StatusCode.OK, "分页查询成功！", pageInfo);
    }

    @PostMapping("/search/{page}/{size}")
    public Result<PageInfo<Brand>> findPage(@RequestBody Brand brand, @PathVariable("page") Integer page, @PathVariable("size") Integer size) {
        PageInfo<Brand> pageInfo = brandService.findPage(brand, page, size);
        return new Result<>(true, StatusCode.OK, "条件分页查询成功！", pageInfo);
    }
}
