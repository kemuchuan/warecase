package com.warecase.service.impl;

import com.warecase.mapper.StatisticsMapper;
import com.warecase.pojo.Statistics;
import com.warecase.service.IStatisticsService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatisticsService implements IStatisticsService {

    @Resource
    private StatisticsMapper statisticsMapper;

    @Override
    public List<Statistics> listStatisticsRefund(Statistics statisticsRefund) {
        return this.statisticsMapper.listStatisticsRefund(statisticsRefund);
    }

    @Override
    public List<Statistics> listStatisticsRepair(Statistics statisticsRepair) {
        return this.statisticsMapper.listStatisticsRepair(statisticsRepair);
    }

    @Override
    public List<Statistics> listStatisticsRecycle(Statistics statisticsRecycle) {
        return this.statisticsMapper.listStatisticsRecycle(statisticsRecycle);
    }
}
