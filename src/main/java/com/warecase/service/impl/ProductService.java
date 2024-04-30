package com.warecase.service.impl;

import com.warecase.mapper.ProductMapper;
import com.warecase.pojo.Product;
import com.warecase.service.IProductService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductService implements IProductService {

    @Resource
    private ProductMapper productMapper;

    @Override
    public List<Product> listProducts(Product product) {
        return this.productMapper.listProducts(product);
    }

    @Override
    public int insertProduct(Product product) {
        return this.productMapper.insertProduct(product);
    }

    @Override
    public int updateProduct(Product product) {
        return this.productMapper.updateProduct(product);
    }

    @Override
    public int deleteProductBySerialId(String serialId) {
        return this.productMapper.deleteProductBySerialId(serialId);
    }

    @Override
    public Product selectProductBySerialId(String serialId) {
        return this.productMapper.selectProductBySerialId(serialId);
    }

    @Override
    public List<Product> selectAllProducts() {
        return this.productMapper.selectAllProducts();
    }

    @Override
    public List<Product> selectProductByPalletid(String palletid) {
        return List.of();
    }
}
