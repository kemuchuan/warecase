package com.warecase.service;

import com.warecase.pojo.Product;

import java.util.List;

public interface IProductService {

    /**
     * 查询产品列表
     * @param product 产品信息
     * @return 产品列表
     */
    List<Product> listProducts(Product product);

    /**
     * 新增产品
     * @param product 产品信息
     * @return 影响行数
     */
    int insertProduct(Product product);

    /**
     * 更新产品信息
     * @param product 产品信息
     * @return 影响行数
     */
    int updateProduct(Product product);

    /**
     * 删除产品信息
     * @param serialId 产品序列号
     * @return 影响行数
     */
    int deleteProductBySerialId(String serialId);

    /**
     * 根据序列号查询产品信息
     * @param serialId 产品序列号
     * @return 产品信息
     */
    Product selectProductBySerialId(String serialId);

    /**
     * 查询所有产品信息
     * @return 产品列表
     */
    List<Product> selectAllProducts();

    /**
     * 根据托盘号查询产品信息
     * @param palletid 托盘号
     * @return 产品列表
     */
    List<Product> selectProductByPalletid(String palletid);

}
