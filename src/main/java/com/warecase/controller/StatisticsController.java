package com.warecase.controller;

import com.warecase.core.common.AjaxResult;
import com.warecase.core.controler.BaseController;
import com.warecase.pojo.Statistics;
import com.warecase.service.IStatisticsService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatisticsController extends BaseController {

    @Resource
    private IStatisticsService statisticsService;

    @GetMapping("/statistics/repair")
    public AjaxResult getStatisticsRepair(Statistics statisticsRepair) {
        return success(statisticsService.listStatisticsRepair(statisticsRepair));
    }

    @GetMapping("/statistics/refund")
    public AjaxResult getStatisticsRefund(Statistics statisticsRefund) {
        return success(statisticsService.listStatisticsRefund(statisticsRefund));
    }

    @GetMapping("/statistics/recycle")
    public AjaxResult getStatisticsRecycle(Statistics statisticsRecycle) {
        return success(statisticsService.listStatisticsRecycle(statisticsRecycle));
    }
}
