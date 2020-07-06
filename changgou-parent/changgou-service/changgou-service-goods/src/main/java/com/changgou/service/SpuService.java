package com.changgou.service;
import com.changgou.goods.pojo.Goods;
import com.changgou.goods.pojo.Spu;
import com.github.pagehelper.PageInfo;
import java.util.List;
/**
 * @Author: pizssn
 * @Description: com.changgou.service
 */
public interface SpuService {

    PageInfo<Spu> findPage(Spu spu, int page, int size);

    PageInfo<Spu> findPage(int page, int size);

    List<Spu> findList(Spu spu);

    void delete(Long id);

    void update(Spu spu);

    void add(Spu spu);

    Spu findById(Long id);

    List<Spu> findAll();

    void save(Goods goods);

    Goods findGoodsById(Long id);

    void auditSpu(Long id);

    void pullSpu(Long id);

    void logicDeleteSpu(Long id);

    void restoreSpu(Long id);
}
