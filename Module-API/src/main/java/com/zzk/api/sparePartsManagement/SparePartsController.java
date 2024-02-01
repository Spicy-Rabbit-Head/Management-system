package com.zzk.api.sparePartsManagement;

import com.zzk.entity.dto.sparePartsRelated.SparePartsInquiryDTO;
import com.zzk.entity.po.sparePartsManagement.CostStatistics;
import com.zzk.entity.po.sparePartsManagement.DeviceSparePartsCost;
import com.zzk.entity.response.Response;
import com.zzk.service.sparePartsRelated.SparePartsQueryService;
import com.zzk.service.sparePartsRelated.SparePartsReviseService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    // 填写费用
    @PostMapping("/fillInFee")
    public Response<Boolean> fillInFee(@RequestBody List<CostStatistics> costStatistics) {
        return Response.success(1, "提交成功", sparePartsReviseService.feeWritingProcess(costStatistics));
    }
}
