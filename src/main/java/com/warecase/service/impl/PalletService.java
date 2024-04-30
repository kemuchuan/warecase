package com.warecase.service.impl;

import com.warecase.mapper.PalletMapper;
import com.warecase.pojo.Pallet;
import com.warecase.service.IPalletService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PalletService implements IPalletService {


    @Resource
    private PalletMapper palletMapper;

    @Override
    public List<Pallet> listPallets(Pallet pallet) {
        return this.palletMapper.listPallets(pallet);
    }

    @Override
    public int insertPallet(Pallet pallet) {
        return this.palletMapper.insertPallet(pallet);
    }

    @Override
    public List<Pallet> selectAllPallets() {
        return this.palletMapper.selectAllPallets();
    }

    @Override
    public Pallet selectPalletById(String palletid) {
        return this.palletMapper.selectPalletById(palletid);
    }

    @Override
    public int updatePallet(Pallet pallet) {
        return this.palletMapper.updatePallet(pallet);
    }

    @Override
    public int deletePallet(String palletid) {
        return this.palletMapper.deletePallet(palletid);
    }
}
