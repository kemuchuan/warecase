package com.warecase.service.impl;

import com.warecase.mapper.StatisticsRepairMapper;
import com.warecase.pojo.StatisticsRepair;
import com.warecase.service.IStatisticsRepairService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatisticsRepairService implements IStatisticsRepairService {

    @Resource
    private StatisticsRepairMapper statisticsRepairMapper;

    @Override
    public List<StatisticsRepair> listStatisticsRepair(StatisticsRepair statisticsRepair) {
        return this.statisticsRepairMapper.listStatisticsRepair(statisticsRepair);
    }
}
