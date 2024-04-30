package com.warecase.controller;

import com.warecase.core.common.AjaxResult;
import com.warecase.core.controler.BaseController;
import com.warecase.pojo.ReturnDetails;
import com.warecase.service.IReturnDetailsService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/returnDetails")
public class ReturnDetailsController extends BaseController {

    // 注入IReturnDetailsService
    @Resource
    private IReturnDetailsService returnDetailsService;

    /**
     * 根据条件分页查询退货明细
     * @param returnDetails 退货明细
     * @return AjaxResult
     */
    @GetMapping("/list")
    public AjaxResult listReturnDetails(ReturnDetails returnDetails) {
        return success(this.returnDetailsService.listReturnDetails(returnDetails));
    }

    /**
     * 获取所有退货明细
     * @return AjaxResult
     */
    @GetMapping
    public AjaxResult getAllReturnDetails() {
        return success(this.returnDetailsService.selectAllReturnDetails());
    }

    /**
     * 根据退货单号获取退货明细
     * @param returnId 退货单号
     * @return AjaxResult
     */
    @GetMapping("/{returnId}")
    public AjaxResult getReturnDetailsByReturnId(@PathVariable("returnId") String returnId) {
        return success(this.returnDetailsService.selectReturnDetailsByReturnId(returnId));
    }

    /**
     * 添加退货明细
     * @param returnDetails 退货明细
     * @return AjaxResult
     */
    @PostMapping
    public AjaxResult addReturnDetails(@RequestBody ReturnDetails returnDetails) {
        return toAjax(this.returnDetailsService.insertReturnDetails(returnDetails));
    }

    /**
     * 更新退货明细
     * @param returnDetails 退货明细
     * @return AjaxResult
     */
    @PutMapping
    public AjaxResult updateReturnDetails(@RequestBody ReturnDetails returnDetails) {
        return toAjax(this.returnDetailsService.updateReturnDetails(returnDetails));
    }

    /**
     *  根据退货单号删除退货明细
     * @param returnId 退货单号
     * @return AjaxResult
     */
    @DeleteMapping("/{returnId}")
    public AjaxResult deleteReturnDetails(@PathVariable("returnId") String returnId) {
        return toAjax(this.returnDetailsService.deleteReturnDetailsByReturnId(returnId));
    }
}
