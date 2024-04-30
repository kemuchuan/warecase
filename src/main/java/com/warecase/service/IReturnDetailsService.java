package com.warecase.service;

import com.warecase.pojo.ReturnDetails;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface IReturnDetailsService {

    /**
     * 查询所有退货明细
     * @param returnDetails 退货明细
     * @return 退货明细列表
     */
    List<ReturnDetails> listReturnDetails(ReturnDetails returnDetails);

    /**
     * 添加退货明细
     * @param returnDetails 退货明细
     * @return 影响行数
     */
    int insertReturnDetails(ReturnDetails returnDetails);

    /**
     * 更新退货明细
     * @param returnDetails 退货明细
     * @return 影响行数
     */
    int updateReturnDetails(ReturnDetails returnDetails);

    /**
     * 删除退货明细
     * @param returnId 退货单id
     * @return 影响行数
     */
    int deleteReturnDetailsByReturnId(String returnId);

    /**
     * 根据退货单id查询退货明细
     * @param returnId 退货单id
     * @return 退货明细
     */
    ReturnDetails selectReturnDetailsByReturnId(String returnId);

    /**
     * 查询所有退货明细
     * @return  退货明细列表
     */
    List<ReturnDetails> selectAllReturnDetails();

}
