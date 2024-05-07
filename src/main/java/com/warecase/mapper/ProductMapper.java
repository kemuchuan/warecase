package com.warecase.mapper;

import com.warecase.pojo.Product;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface ProductMapper {

    /**
     * 根据产品对象信息查询产品列表
     * @param product 产品信息对象
     * @return 产品列表
     */
    List<Product> listProducts(Product product);

    /**
     * 插入产品信息
     * @param product 产品信息对象
     * @return 影响行数
     */
    @Insert("insert into product(serial_id, name, category, palletid) value (#{serialId},#{name},#{category},#{palletid})")
    int insertProduct(Product product);

    /**
     * 更新产品信息
     * @param product 产品信息对象
     * @return 影响行数
     */
    int updateProduct(Product product);

    /**
     * 根据产品序列号删除产品信息
     * @param serialId 产品序列号
     * @return 影响行数
     */
    @Delete("delete from product where serial_id = #{serialId}")
    int deleteProductBySerialId(String serialId);

    /**
     * 根据产品序列号查询产品信息
     * @param serialId 产品序列号
     * @return 产品信息对象
     */
    @Select("select * from product where serial_id = #{serialId}")
    Product selectProductBySerialId(String serialId);

    /**
     * 查询所有产品信息
     * @return 产品列表
     */
    @Select("select * from product")
    List<Product> selectAllProducts();

    /**
     * 根据产品名称查询产品信息
     * @param name 产品名称
     * @return 产品信息对象
     */
    @Select("select serial_id, name, category, palletid from product where name = #{name}")
    Product selectProductByName(String name);

}
