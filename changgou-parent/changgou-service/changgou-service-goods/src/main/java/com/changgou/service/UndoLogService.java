package com.changgou.service;

import com.changgou.goods.pojo.UndoLog;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @Author: pizssn
 * @Description: com.changgou.service
 */
public interface UndoLogService {

    PageInfo<UndoLog> findPage(UndoLog undoLog, int page, int size);

    PageInfo<UndoLog> findPage(int page, int size);

    List<UndoLog> findList(UndoLog undoLog);

    void delete(Long id);

    void update(UndoLog undoLog);

    void add(UndoLog undoLog);

    UndoLog findById(Long id);

    List<UndoLog> findAll();
}
