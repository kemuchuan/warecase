package com.warecase.controller;

import com.warecase.core.common.AjaxResult;
import com.warecase.core.controler.BaseController;
import com.warecase.pojo.Product;
import com.warecase.service.IProductService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController extends BaseController {

    // 注入ProductService
    @Resource
    private IProductService productService;

    /**
     * 获取产品列表
     * @param product 产品条件
     * @return 产品列表
     */
    @GetMapping("/list")
    public AjaxResult listProducts(Product product) {
        return success(this.productService.listProducts(product));
    }

    /**
     * 获取所有产品
     * @return 产品列表
     */
    @GetMapping
    public AjaxResult getProducts() {
        return success(this.productService.selectAllProducts());
    }

    /**
     * 获取单个产品
     * @param serialId 产品序列号
     * @return 产品
     */
    @GetMapping("/{serialId}")
    public AjaxResult getProduct(@PathVariable String serialId) {
        return success(this.productService.selectProductBySerialId(serialId));
    }

    /**
     * 添加产品
     * @param product 产品
     * @return 成功或失败
     */
    @PostMapping
    public AjaxResult addProduct(@RequestBody Product product) {
        return toAjax(this.productService.insertProduct(product));
    }

    /**
     * 更新产品
     * @param product 产品
     * @return 成功或失败
     */
    @PutMapping
    public AjaxResult updateProduct(@RequestBody Product product) {
        return toAjax(this.productService.updateProduct(product));
    }

    /**
     * 删除产品
     * @param serialId 产品序列号
     * @return 成功或失败
     */
    @DeleteMapping("/{serialId}")
    public AjaxResult deleteProduct(@PathVariable String serialId) {
        return toAjax(this.productService.deleteProductBySerialId(serialId));
    }

}
