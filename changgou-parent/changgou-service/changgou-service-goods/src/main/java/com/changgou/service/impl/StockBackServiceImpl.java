package com.changgou.service.impl;
import com.changgou.dao.StockBackMapper;
import com.changgou.goods.pojo.StockBack;
import com.changgou.service.StockBackService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import java.util.List;

/**
 * @Author: pizssn
 * @Description: com.changgou.service.impl
 */
@Service
public class StockBackServiceImpl implements StockBackService {

    @Autowired
    private StockBackMapper stockBackMapper;

    @Override
    public PageInfo<StockBack> findPage(StockBack stockBack, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(stockBack);
        //执行搜索
        return new PageInfo<StockBack>(stockBackMapper.selectByExample(example));
    }

    @Override
    public PageInfo<StockBack> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<StockBack>(stockBackMapper.selectAll());
    }

    @Override
    public List<StockBack> findList(StockBack stockBack){
        //构建查询条件
        Example example = createExample(stockBack);
        //根据构建的条件查询数据
        return stockBackMapper.selectByExample(example);
    }

    public Example createExample(StockBack stockBack){
        Example example=new Example(StockBack.class);
        Example.Criteria criteria = example.createCriteria();
        if(stockBack!=null){
            // 订单id
            if(!StringUtils.isEmpty(stockBack.getOrderId())){
                    criteria.andEqualTo("orderId",stockBack.getOrderId());
            }
            // SKU的id
            if(!StringUtils.isEmpty(stockBack.getSkuId())){
                    criteria.andEqualTo("skuId",stockBack.getSkuId());
            }
            // 回滚数量
            if(!StringUtils.isEmpty(stockBack.getNum())){
                    criteria.andEqualTo("num",stockBack.getNum());
            }
            // 回滚状态
            if(!StringUtils.isEmpty(stockBack.getStatus())){
                    criteria.andEqualTo("status",stockBack.getStatus());
            }
            // 创建时间
            if(!StringUtils.isEmpty(stockBack.getCreateTime())){
                    criteria.andEqualTo("createTime",stockBack.getCreateTime());
            }
            // 回滚时间
            if(!StringUtils.isEmpty(stockBack.getBackTime())){
                    criteria.andEqualTo("backTime",stockBack.getBackTime());
            }
        }
        return example;
    }

    @Override
    public void delete(String id){
        stockBackMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改StockBack
     * @param stockBack
     */
    @Override
    public void update(StockBack stockBack){
        stockBackMapper.updateByPrimaryKey(stockBack);
    }

    @Override
    public void add(StockBack stockBack){
        stockBackMapper.insert(stockBack);
    }

    @Override
    public StockBack findById(String id){
        return  stockBackMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<StockBack> findAll() {
        return stockBackMapper.selectAll();
    }
}
