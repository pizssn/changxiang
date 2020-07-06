package com.changgou.service;
import com.changgou.goods.pojo.Pref;
import com.github.pagehelper.PageInfo;
import java.util.List;
/**
 * @Author: pizssn
 * @Description: com.changgou.service
 */
public interface PrefService {

    PageInfo<Pref> findPage(Pref pref, int page, int size);

    PageInfo<Pref> findPage(int page, int size);

    List<Pref> findList(Pref pref);

    void delete(Integer id);

    void update(Pref pref);

    void add(Pref pref);

     Pref findById(Integer id);

    List<Pref> findAll();
}
