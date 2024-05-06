package com.warecase.controller;

import com.warecase.core.common.AjaxResult;
import com.warecase.core.controler.BaseController;
import com.warecase.pojo.Statistics;
import com.warecase.service.IStatisticsService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/statistics")
public class StatisticsController extends BaseController {

    /**
     * 注入统计服务接口
     */
    @Resource
    private IStatisticsService statisticsService;

    /**
     * 获取全部统计数据
     * @return 统计数据
     */
    @GetMapping
    public AjaxResult getStatistics(Statistics statistics) {
        return success(statisticsService.listStatistics(statistics));
    }

    /**
     * 获取维修统计数据
     * @param statisticsRepair 维修统计数据
     * @return 维修统计数据
     */
    @GetMapping("/repair")
    public AjaxResult getStatisticsRepair(Statistics statisticsRepair) {
        return success(statisticsService.listStatisticsRepair(statisticsRepair));
    }

    /**
     * 获取退货统计数据
     * @param statisticsRefund 退货统计数据
     * @return 退货统计数据
     */
    @GetMapping("/refund")
    public AjaxResult getStatisticsRefund(Statistics statisticsRefund) {
        return success(statisticsService.listStatisticsRefund(statisticsRefund));
    }

    /**
     * 获取回收统计数据
     * @param statisticsRecycle 回收统计数据
     * @return 回收统计数据
     */
    @GetMapping("/recycle")
    public AjaxResult getStatisticsRecycle(Statistics statisticsRecycle) {
        return success(statisticsService.listStatisticsRecycle(statisticsRecycle));
    }

    /**
     * 插入统计数据
     * @param statistics 统计数据
     * @return 插入结果
     */
    @PostMapping
    public AjaxResult insertStatistics(@RequestBody Statistics statistics) {
        return toAjax(statisticsService.insertStatistics(statistics));
    }


    /**
     * 更新统计数据
     * @param statistics 统计数据
     * @return 更新结果
     */
    @PutMapping
    public AjaxResult updateStatistics(@RequestBody Statistics statistics){
        return toAjax(statisticsService.updateStatistics(statistics));
    }

    /**
     * 删除统计数据
     * @param returnId 统计数据id
     * @return 删除结果
     */
    @DeleteMapping("/{returnId}")
    public AjaxResult deleteStatistics(@PathVariable("returnId") String returnId){
        return toAjax(statisticsService.deleteStatistics(returnId));
    }
}
