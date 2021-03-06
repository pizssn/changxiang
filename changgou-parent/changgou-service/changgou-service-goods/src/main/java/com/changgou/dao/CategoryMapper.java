package com.changgou.dao;

import com.changgou.goods.pojo.Category;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/**
 * @Author: pizssn
 * @Description: com.changgou.dao
 */
@Repository
public interface CategoryMapper extends Mapper<Category> {
}
