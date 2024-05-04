package com.warecase.service;

import com.warecase.pojo.Statistics;

import java.util.List;

public interface IStatisticsService {

    List<Statistics> listStatisticsRefund(Statistics statisticsRefund);


    List<Statistics> listStatisticsRepair(Statistics statisticsRepair);


    List<Statistics> listStatisticsRecycle(Statistics statisticsRecycle);

}
