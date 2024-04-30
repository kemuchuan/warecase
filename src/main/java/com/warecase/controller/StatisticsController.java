package com.warecase.controller;

import com.warecase.core.common.AjaxResult;
import com.warecase.core.controler.BaseController;
import com.warecase.pojo.StatisticsRecycle;
import com.warecase.pojo.StatisticsRefund;
import com.warecase.pojo.StatisticsRepair;
import com.warecase.service.IStatisticsRecycleService;
import com.warecase.service.IStatisticsRefundService;
import com.warecase.service.IStatisticsRepairService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatisticsController extends BaseController {

    @Resource
    private IStatisticsRepairService statisticsRepairService;

    @Resource
    private IStatisticsRefundService statisticsRefundService;

    @Resource
    private IStatisticsRecycleService statisticsRecycleService;

    @GetMapping("/statistics/repair")
    public AjaxResult getStatisticsRepair(StatisticsRepair statisticsRepair) {
        return success(statisticsRepairService.listStatisticsRepair(statisticsRepair));
    }

    @GetMapping("/statistics/refund")
    public AjaxResult getStatisticsRefund(StatisticsRefund statisticsRefund) {
        return success(statisticsRefundService.listStatisticsRefund(statisticsRefund));
    }

    @GetMapping("/statistics/recycle")
    public AjaxResult getStatisticsRecycle(StatisticsRecycle statisticsRecycle) {
        return success(statisticsRecycleService.listStatisticsRecycle(statisticsRecycle));
    }
}
