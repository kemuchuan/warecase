package com.warecase.mapper;

import com.warecase.pojo.StatisticsRepair;

import java.util.List;

public interface StatisticsRepairMapper {

    /**
     * 查询维修统计信息
     * @param statisticsRepair 条件查询参数
     * @return 维修统计信息列表
     */
    List<StatisticsRepair> listStatisticsRepair(StatisticsRepair statisticsRepair);

}
