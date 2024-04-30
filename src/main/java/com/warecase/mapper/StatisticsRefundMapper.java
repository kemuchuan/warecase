package com.warecase.mapper;

import com.warecase.pojo.StatisticsRefund;

import java.util.List;

public interface StatisticsRefundMapper {

    /**
     * 查询退款统计信息
     * @param statisticsRefund 退款统计信息
     * @return 退款统计信息列表
     */
    List<StatisticsRefund> listStatisticsRefund(StatisticsRefund statisticsRefund);

}
