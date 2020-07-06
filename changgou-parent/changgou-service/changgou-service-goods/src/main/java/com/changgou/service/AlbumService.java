package com.changgou.service;

import com.changgou.goods.pojo.Album;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @Author: pizssn
 * @Description: com.changgou.service
 */
public interface AlbumService {

    //Album多条件分页查询
    PageInfo<Album> findPage(Album album, int page, int size);

    //Album分页查询
    PageInfo<Album> findPage(int page, int size);

    //Album多条件搜索方法
    List<Album> findList(Album album);

    //删除Album
    void delete(Long id);

    //修改Album数据
    void update(Album album);

    //新增Album
    void add(Album album);

    //根据ID查询Album
    Album findById(Long id);

    //查询所有Album
    List<Album> findAll();
}
