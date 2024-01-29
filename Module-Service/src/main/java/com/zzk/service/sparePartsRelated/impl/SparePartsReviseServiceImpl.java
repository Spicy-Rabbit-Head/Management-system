package com.zzk.service.sparePartsRelated.impl;

import com.zzk.dao.sparePartsRelated.CostTransferDao;
import com.zzk.entity.dto.sparePartsRelated.ActualCostDTO;
import com.zzk.service.sparePartsRelated.SparePartsReviseService;
import org.springframework.stereotype.Service;

@Service
public class SparePartsReviseServiceImpl implements SparePartsReviseService {
    private final CostTransferDao costTransferDao;

    public SparePartsReviseServiceImpl(CostTransferDao costTransferDao) {
        this.costTransferDao = costTransferDao;
    }

    /**
     * 是否存在该设备
     *
     * @param deviceNumber 设备编号
     */
    @Override
    public Boolean isExistDevice(String deviceNumber) {
        return costTransferDao.isExistDevice(deviceNumber);
    }

    /**
     * 添加初始费用
     *
     * @param deviceNumber     设备编号
     * @param maintenanceCycle 保养周期
     */
    @Override
    public Boolean addInitialCost(String deviceNumber, String maintenanceCycle) {
        return costTransferDao.addInitialCost(deviceNumber, maintenanceCycle) > 0;
    }

    /**
     * 添加实际费用
     *
     * @param actualCost 实际使用量
     */
    @Override
    public Boolean addActualCost(ActualCostDTO actualCost) {
        return true;
    }
}
