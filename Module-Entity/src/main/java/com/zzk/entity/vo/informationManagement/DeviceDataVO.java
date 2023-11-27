package com.zzk.entity.vo.informationManagement;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

/**
 * 设备数据视图对象<br>
 * <p>
 * <p>
 * 1.0版本 : 2023-11-23 08:25<br>
 * 构建设备数据视图对象<br>
 * <p>
 *
 * @author zhao'zi'kui
 * @version 1.0
 * @since 2023-11-23 08:25
 */
@Data
@AllArgsConstructor
public class DeviceDataVO {
    // 设备编号
    private String deviceNumber;
    // 设备名称
    private String deviceName;
    // 设备型号
    private String deviceModel;
    // 制作厂商
    private String manufacturer;
    // 车间
    private String workshop;
    // 站别
    private String station;
    // 位置
    private String location;
    // 设备状态
    private String deviceStatus;
    // 是否有效
    private Boolean isValid;
    // 保养规则名
    private String ruleName;
    // 启用日期
    private Integer enableDate;
    // 保养基准文号
    private String benchmarkDocumentNumber;
    // OIS文号
    private String oisDocumentNumber;
    // 每日设备巡检基准
    private String deviceInspectionBenchmark;
    // 变更日期
    private Date changeDate;
    // 总数
    private Integer total;
}
