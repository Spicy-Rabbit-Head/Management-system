package com.zzk.dao.sparePartsRelated;

import com.zzk.entity.po.sparePartsManagement.SparePartsData;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 备品数据访问层<br>
 * <p>
 * <p>
 * 1.0版本：备品数据访问层<br>
 * <p>
 *
 * @author zhao'zi'kui
 * @version 1.0
 * @since 2023-11-17 13:51
 */
@Repository
public interface SparePartsDataDao {
    /**
     * 根据备品编号查询备品数据
     *
     * @param sparePartsNumber 备品编号
     * @return 备品数据
     * @since 1.0
     */
    List<SparePartsData> selectSparePartsDataBySparePartsNumber(String sparePartsNumber);
}