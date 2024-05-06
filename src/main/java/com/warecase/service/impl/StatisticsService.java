package com.warecase.service.impl;

import com.warecase.mapper.ProductMapper;
import com.warecase.mapper.ReturnDetailsMapper;
import com.warecase.mapper.StatisticsMapper;
import com.warecase.mapper.UserMapper;
import com.warecase.pojo.ReturnDetails;
import com.warecase.pojo.Statistics;
import com.warecase.pojo.User;
import com.warecase.service.IStatisticsService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class StatisticsService implements IStatisticsService {

    @Resource
    private StatisticsMapper statisticsMapper;

    @Resource
    private UserMapper userMapper;

    @Resource
    private ReturnDetailsMapper returnDetailsMapper;

    @Override
    public List<Statistics> listStatistics(Statistics statistics) {
        return this.statisticsMapper.listStatistics(statistics);
    }

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

    public int insertStatistics(Statistics statistics) {
        ReturnDetails returnDetails = new ReturnDetails();
        returnDetails.setReturnDate(new Date());
        returnDetails.setSerialId(statistics.getSerialId());
        User user = this.userMapper.selectUserByName(statistics.getUsername());
        returnDetails.setUserId(user.getUserId());
        returnDetails.setReturnType(statistics.getReturnType());
        return this.returnDetailsMapper.insertReturnDetails(returnDetails);
    }

    @Override
    public int updateStatistics(Statistics statistics) {
        ReturnDetails returnDetails = new ReturnDetails();
        returnDetails.setReturnDate(statistics.getReturnDate());
        returnDetails.setSerialId(statistics.getSerialId());
        User user = this.userMapper.selectUserByName(statistics.getUsername());
        returnDetails.setUserId(user.getUserId());
        returnDetails.setReturnType(statistics.getReturnType());
        returnDetails.setReturnId(statistics.getReturnId());
        return this.returnDetailsMapper.updateReturnDetails(returnDetails);
    }

    @Override
    public int deleteStatistics(String returnId) {
        return this.returnDetailsMapper.deleteReturnDetailsByReturnId(returnId);
    }
}
