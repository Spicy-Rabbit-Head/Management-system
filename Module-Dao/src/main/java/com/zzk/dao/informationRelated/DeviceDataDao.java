package com.zzk.dao.informationRelated;

import com.zzk.entity.vo.informationManagement.DeviceDataVO;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * 设备数据表(DeviceData)表数据库访问层<br>
 * <p>
 * <p>
 * 1.0版本：2023-11-22 14:40<br>
 * 构建设备数据相关数据访问层<br>
 * <p>
 *
 * @author zhao'zi'kui
 * @version 1.0
 * @since 2023-11-22 14:40
 */
@Repository
public interface DeviceDataDao {
    /**
     * 查询设备数据
     *
     * @param offset   偏移量 从第几条数据开始
     * @param pageSize 页面大小 每页显示多少条数据
     *
     * @return 设备数据
     */
    @Select("SELECT * ,COUNT(*) OVER () AS total FROM information_management.device_data OFFSET #{offset} FETCH FIRST #{pageSize} ROWS ONLY")
    DeviceDataVO[] select(Integer offset, Integer pageSize);
}
