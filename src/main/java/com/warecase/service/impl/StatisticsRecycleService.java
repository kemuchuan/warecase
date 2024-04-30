package com.warecase.service.impl;

import com.warecase.mapper.StatisticsRecycleMapper;
import com.warecase.pojo.StatisticsRecycle;
import com.warecase.service.IStatisticsRecycleService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatisticsRecycleService implements IStatisticsRecycleService {

    @Resource
    private StatisticsRecycleMapper statisticsRecycleMapper;

    @Override
    public List<StatisticsRecycle> listStatisticsRecycle(StatisticsRecycle statisticsRecycle) {
        return this.statisticsRecycleMapper.listStatisticsRecycle(statisticsRecycle);
    }
}
