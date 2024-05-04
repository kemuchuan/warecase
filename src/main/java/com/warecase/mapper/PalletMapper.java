package com.warecase.mapper;

import com.warecase.pojo.Pallet;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;

import java.util.List;

public interface PalletMapper {

    /**
     * 根据托盘对象信息查询托盘列表
     * @param pallet 托盘对象
     * @return 返回托盘列表
     */
    List<Pallet> listPallets(Pallet pallet);

    /**
     * 添加一个新的托盘
     * @param pallet 托盘对象
     * @return 返回受影响的行数
     */
    @Insert("insert into pallet(palletid,return_date,number,lorryid) value(#{palletid},#{returnDate},#{number},#{lorryid})")
    int insertPallet(Pallet pallet);

    /**
     * 查询所有托盘
     * @return 返回所有托盘的列表
     */
    @Select("select * from pallet")
    List<Pallet> selectAllPallets();

    /**
     * 根据托盘ID查询托盘信息
     * @param palletid 托盘ID
     * @return 返回托盘对象
     */
    @Select("select * from pallet where palletid = #{palletid}")
    Pallet selectPalletById(String palletid);

    /**
     * 根据托盘ID更新托盘信息
     * @param pallet 托盘对象
     * @return 返回受影响的行数
     */
    int updatePallet(Pallet pallet);

    /**
     * 根据托盘ID删除托盘信息
     * @param palletid 托盘ID
     * @return 返回受影响的行数
     */
    @Delete("delete from pallet where palletid = #{palletid}")
    int deletePallet(String palletid);

}
