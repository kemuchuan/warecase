package com.warecase.service.impl;

import com.warecase.mapper.ReturnDetailsMapper;
import com.warecase.pojo.ReturnDetails;
import com.warecase.service.IReturnDetailsService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ReturnDetailsService implements IReturnDetailsService {

    @Resource
    private ReturnDetailsMapper returnDetailsMapper;

    @Override
    public List<ReturnDetails> listReturnDetails(ReturnDetails returnDetails) {
        return this.returnDetailsMapper.listReturnDetails(returnDetails);
    }

    @Override
    public int insertReturnDetails(ReturnDetails returnDetails) {
        returnDetails.setReturnDate(new Date());
        return this.returnDetailsMapper.insertReturnDetails(returnDetails);
    }

    @Override
    public int updateReturnDetails(ReturnDetails returnDetails) {
        return this.returnDetailsMapper.updateReturnDetails(returnDetails);
    }

    @Override
    public int deleteReturnDetailsByReturnId(String returnId) {
        return this.returnDetailsMapper.deleteReturnDetailsByReturnId(returnId);
    }

    @Override
    public ReturnDetails selectReturnDetailsByReturnId(String returnId) {
        return this.returnDetailsMapper.selectReturnDetailsByReturnId(returnId);
    }

    @Override
    public List<ReturnDetails> selectAllReturnDetails() {
        return this.returnDetailsMapper.selectAllReturnDetails();
    }
}
