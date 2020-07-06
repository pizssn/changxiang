package com.changgou.service;
import com.changgou.goods.pojo.StockBack;
import com.github.pagehelper.PageInfo;
import java.util.List;
/**
 * @Author: pizssn
 * @Description: com.changgou.service
 */
public interface StockBackService {

    PageInfo<StockBack> findPage(StockBack stockBack, int page, int size);

    PageInfo<StockBack> findPage(int page, int size);

    List<StockBack> findList(StockBack stockBack);

    void delete(String id);

    void update(StockBack stockBack);

    void add(StockBack stockBack);

    StockBack findById(String id);

    List<StockBack> findAll();
}
