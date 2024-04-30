package com.warecase.mapper;

import com.warecase.pojo.StatisticsRecycle;

import java.util.List;

public interface StatisticsRecycleMapper {

    /**
     * 查询回收站统计信息
     * @param statisticsRecycle 条件查询参数
     * @return 回收站统计信息
     */
    List<StatisticsRecycle> listStatisticsRecycle(StatisticsRecycle statisticsRecycle);

}
