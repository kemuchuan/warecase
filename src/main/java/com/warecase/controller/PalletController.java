package com.warecase.controller;

import com.warecase.core.common.AjaxResult;
import com.warecase.core.controler.BaseController;
import com.warecase.pojo.Pallet;
import com.warecase.service.impl.PalletService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pallet")
public class PalletController extends BaseController {

    // 自动注入PalletService
    @Resource
    private PalletService palletService;

    /**
     * 获取pallet
     * @param pallet Pallet
     * @return 返回结果
     */
    @GetMapping("/list")
    public AjaxResult listPallets(Pallet pallet) {
        return success(this.palletService.listPallets(pallet));
    }

    /**
     * 获取所有pallet
     * @return AjaxResult
     */
    @GetMapping
    public AjaxResult getAllPallets() {
        return success(palletService.selectAllPallets());
    }

    @GetMapping("/{palletid}")
    public AjaxResult getPalletById(@PathVariable("palletid") String palletid) {
        return success(palletService.selectPalletById(palletid));
    }

    @PostMapping
    public AjaxResult addPallet(@RequestBody Pallet pallet) {
        return toAjax(palletService.insertPallet(pallet));
    }

    @PutMapping
    public AjaxResult updatePallet(@RequestBody Pallet pallet) {
        return toAjax(palletService.updatePallet(pallet));
    }

    @DeleteMapping("/{palletid}")
    public AjaxResult deletePallet(@PathVariable("palletid") String palletid) {
        return toAjax(palletService.deletePallet(palletid));
    }

}
