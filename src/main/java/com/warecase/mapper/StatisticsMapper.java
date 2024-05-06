package com.warecase.mapper;

import com.warecase.pojo.Statistics;

import java.util.List;

public interface StatisticsMapper {

    /**
     * 查询统计数据
     * @return 统计数据
     */
    List<Statistics> listStatistics(Statistics statistics);

    /**
     * 查询回收站统计信息
     * @param statisticsRecycle 条件查询参数
     * @return 回收站统计信息
     */
    List<Statistics> listStatisticsRecycle(Statistics statisticsRecycle);


    /**
     * 查询维修统计信息
     * @param statisticsRepair 条件查询参数
     * @return 维修统计信息列表
     */
    List<Statistics> listStatisticsRepair(Statistics statisticsRepair);


    /**
     * 查询退款统计信息
     * @param statistics 退款统计信息
     * @return 退款统计信息列表
     */
    List<Statistics> listStatisticsRefund(Statistics statistics);


}
