package com.zzk.api.sparePartsManagement;

import com.zzk.entity.dto.sparePartsRelated.ActualCostDTO;
import com.zzk.entity.dto.sparePartsRelated.SparePartsInquiryDTO;
import com.zzk.entity.po.sparePartsManagement.DeviceSparePartsCost;
import com.zzk.entity.response.Response;
import com.zzk.service.sparePartsRelated.SparePartsQueryService;
import com.zzk.service.sparePartsRelated.SparePartsReviseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/spareParts")
public class SparePartsController {
    private final SparePartsQueryService sparePartsQueryService;
    private final SparePartsReviseService sparePartsReviseService;

    public SparePartsController(SparePartsQueryService sparePartsQueryService, SparePartsReviseService sparePartsReviseService) {
        this.sparePartsQueryService = sparePartsQueryService;
        this.sparePartsReviseService = sparePartsReviseService;
    }

    // 根据设备编号查询
    @PostMapping("/getSparePartsData")
    public Response<List<DeviceSparePartsCost>> getSparePartsData(@RequestBody List<SparePartsInquiryDTO> sparePartsInquiryDTO) {
        return Response.success(1, "查询成功", sparePartsQueryService.getSparePartsData(sparePartsInquiryDTO));
    }

    // 查询领取状态
    @GetMapping("/getReceiveStatus")
    public Response<Boolean> getReceiveStatus(String deviceNumber) {
        return Response.success(1, "查询成功", sparePartsReviseService.isExistDevice(deviceNumber));
    }

    // 添加初始费用
    @PostMapping("/addInitialCost")
    public Response<Boolean> addInitialCost() {
//        System.out.println(receiveSparePartsDTO);
//        return Response.success(1, "添加成功", sparePartsReviseService.addInitialCost(receiveSparePartsDTO.getDeviceNumber(), receiveSparePartsDTO.getMaintenanceCycle()));
        return Response.success(1, "添加成功", null);
    }

    // 添加实际费用
    @PostMapping("/addActualCost")
    public Response<Boolean> addActualCost(@RequestBody ActualCostDTO actualCost) {
        return Response.success(1, "添加成功", sparePartsReviseService.addActualCost(actualCost));
    }
}
