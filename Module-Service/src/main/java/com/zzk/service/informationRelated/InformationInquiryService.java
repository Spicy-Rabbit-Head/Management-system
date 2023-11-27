package com.zzk.service.informationRelated;

import com.zzk.entity.vo.informationManagement.DeviceDataVO;

/**
 * 资料查询相关服务接口<br>
 * <p>
 * <p>
 * 1.0版本：设备数据相关服务接口构建<br>
 * <p>
 *
 * @author zhao'zi'kui
 * @version 1.0
 * @since 2023-11-22 14:54
 */
public interface InformationInquiryService {
    /**
     * 获取设备数据
     *
     * @param offset   偏移量 从第几条数据开始
     * @param pageSize 页面大小 每页显示多少条数据
     *
     * @return 设备数据
     */
    DeviceDataVO[] getDeviceData(Integer offset, Integer pageSize);
}
