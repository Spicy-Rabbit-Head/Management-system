package com.zzk.api.informationManagement;

import com.zzk.entity.response.Response;
import com.zzk.entity.vo.informationManagement.DeviceDataVO;
import com.zzk.service.informationRelated.InformationInquiryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 信息查询相关接口<br>
 * <p>
 * <p>
 * 1.0版本：信息查询相关接口构建<br>
 * <p>
 *
 * @author zhao'zi'kui
 * @version 1.0
 * @since 2023-11-22 15:01
 */
@RestController
@RequestMapping("/information")
public class InformationInquiryController {
    // 信息查询服务
    private final InformationInquiryService informationInquiryService;

    // 构造器注入信息查询服务
    public InformationInquiryController(InformationInquiryService informationInquiryService) {
        this.informationInquiryService = informationInquiryService;
    }

    /**
     * 获取设备数据
     *
     * @param offset   偏移量 从第几条数据开始
     * @param pageSize 页面大小 每页显示多少条数据
     */
    @GetMapping("/getDeviceData")
    public Response<DeviceDataVO[]> getDeviceData(Integer offset, Integer pageSize) {
        DeviceDataVO[] deviceData = informationInquiryService.getDeviceData(offset, pageSize);
        if (deviceData == null) {
            return Response.failed(500, "获取设备数据失败", null);
        }
        return Response.success(200, "获取设备数据成功", deviceData);
    }
}
