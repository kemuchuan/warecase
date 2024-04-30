package com.warecase.service;

import com.warecase.pojo.Pallet;

import java.util.List;

public interface IPalletService {

    /**
     * 查询托盘列表
     * @param pallet 托盘对象
     * @return 返回托盘列表
     */
    List<Pallet> listPallets(Pallet pallet);

    /**
     * 添加一个新的托盘
     * @param pallet 托盘对象
     * @return 返回受影响的行数
     */
    int insertPallet(Pallet pallet);

    /**
     * 查询所有托盘
     * @return 返回所有托盘的列表
     */
    List<Pallet> selectAllPallets();

    /**
     * 根据托盘ID查询托盘信息
     * @param palletid 托盘ID
     * @return 返回托盘对象
     */
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
    int deletePallet(String palletid);

}
