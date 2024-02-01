package com.zzk.service.sparePartsRelated.impl;

import com.zzk.dao.maintenanceScheduleRelated.SchedulingDataDao;
import com.zzk.dao.sparePartsRelated.CostStatisticsDao;
import com.zzk.entity.po.sparePartsManagement.CostStatistics;
import com.zzk.service.sparePartsRelated.SparePartsReviseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SparePartsReviseServiceImpl implements SparePartsReviseService {
    private final CostStatisticsDao costStatisticsDao;
    private final SchedulingDataDao schedulingDataDao;

    public SparePartsReviseServiceImpl(CostStatisticsDao costTransferDao, SchedulingDataDao schedulingDataDao) {
        this.costStatisticsDao = costTransferDao;
        this.schedulingDataDao = schedulingDataDao;
    }

    /**
     * 添加实际费用
     *
     * @param actualCost 实际使用量
     * @return 是否添加成功
     */
    @Override
    public Boolean feeWritingProcess(List<CostStatistics> actualCost) {
        schedulingDataDao.archiveScheduling(schedulingDataDao.queryByDeviceNumber(actualCost.get(0).getDeviceNumber()));
        schedulingDataDao.deleteByDeviceNumber(actualCost.get(0).getDeviceNumber());
        return costStatisticsDao.insertCostRecordBatch(actualCost) > 0;
    }
}
