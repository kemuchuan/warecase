package com.warecase.service.impl;

import com.warecase.mapper.StatisticsRecycleMapper;
import com.warecase.mapper.StatisticsRefundMapper;
import com.warecase.pojo.StatisticsRefund;
import com.warecase.service.IStatisticsRefundService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatisticsRefundService implements IStatisticsRefundService {

    @Resource
    private StatisticsRefundMapper statisticsRecycleMapper;

    @Override
    public List<StatisticsRefund> listStatisticsRefund(StatisticsRefund statisticsRefund) {
        return this.statisticsRecycleMapper.listStatisticsRefund(statisticsRefund);
    }

}
