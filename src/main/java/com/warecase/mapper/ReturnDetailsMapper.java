package com.warecase.mapper;

import com.warecase.pojo.ReturnDetails;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface ReturnDetailsMapper {

    /**
     * 查询退货明细列表
     * @param returnDetails 退货明细
     * @return 退货明细列表
     */
    List<ReturnDetails> listReturnDetails(ReturnDetails returnDetails);

    /**
     * 根据退货单id查询退货明细
     * @param returnId 退货单id
     * @return 退货明细
     */
    @Select("select * from returndetails where return_id = #{returnId}")
    ReturnDetails selectReturnDetailsByReturnId(String returnId);

    /**
     * 查询所有退货明细
     * @return  退货明细列表
     */
    @Select("select * from returndetails")
    List<ReturnDetails> selectAllReturnDetails();

    /**
     * 添加退货明细
     * @param returnDetails 退货明细
     * @return 影响行数
     */
    @Insert("insert into returndetails( return_id,userId, return_type, return_date, serial_id) value(#{returnId},#{userId},#{returnType},#{returnDate},#{serialId})")
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
    @Delete("delete from returndetails where return_id = #{returnId}")
    int deleteReturnDetailsByReturnId(String returnId);


}
