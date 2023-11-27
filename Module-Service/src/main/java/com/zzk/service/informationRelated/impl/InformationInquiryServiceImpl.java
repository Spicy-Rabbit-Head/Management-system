package com.zzk.service.informationRelated.impl;

import com.zzk.dao.informationRelated.DeviceDataDao;
import com.zzk.entity.vo.informationManagement.DeviceDataVO;
import com.zzk.service.informationRelated.InformationInquiryService;
import org.springframework.stereotype.Service;

/**
 * 设备数据相关服务接口实现类<br>
 * <p>
 * <p>
 * 1.0版本：设备数据相关服务接口实现类构建<br>
 * <p>
 *
 * @author zhao'zi'kui
 * @version 1.0
 * @since 2023-11-22 14:57
 */
@Service
public class InformationInquiryServiceImpl implements InformationInquiryService {
    // 设备数据
    private final DeviceDataDao deviceDataDao;

    public InformationInquiryServiceImpl(DeviceDataDao deviceDataDao) {
        this.deviceDataDao = deviceDataDao;
    }

    /**
     * 获取设备数据
     *
     * @param offset   偏移量 从第几条数据开始
     * @param pageSize 页面大小 每页显示多少条数据
     *
     * @return 设备数据
     */
    @Override
    public DeviceDataVO[] getDeviceData(Integer offset, Integer pageSize) {
        return deviceDataDao.select(offset, pageSize);
    }
}
