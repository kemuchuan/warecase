package com.warecase.service;

import com.warecase.pojo.Statistics;

import java.util.List;

public interface IStatisticsService {

    /**
     * 查询统计数据
     * @param statistics 统计数据条件
     * @return 统计数据
     */
    List<Statistics> listStatistics(Statistics statistics);

    /**
     * 查询统计数据
     * @param statisticsRefund 统计退货数据条件
     * @return 统计数据
     */
    List<Statistics> listStatisticsRefund(Statistics statisticsRefund);


    /**
     * 查询统计数据
     * @param statisticsRepair 统计维修数据条件
     * @return 统计数据
     */
    List<Statistics> listStatisticsRepair(Statistics statisticsRepair);


    /**
     * 查询统计数据
     * @param statisticsRecycle 统计回收数据条件
     * @return 统计数据
     */
    List<Statistics> listStatisticsRecycle(Statistics statisticsRecycle);

    /**
     * 插入统计数据
     * @param statistics 统计数据
     * @return 插入结果
     */
    int insertStatistics(Statistics statistics);

    /**
     * 更新统计数据
     * @param statistics 统计数据
     * @return 更新结果
     */
    int updateStatistics(Statistics statistics);

    /**
     * 删除统计数据
     * @param returnId 统计数据
     * @return 删除结果
     */
    int deleteStatistics(String returnId);
}
