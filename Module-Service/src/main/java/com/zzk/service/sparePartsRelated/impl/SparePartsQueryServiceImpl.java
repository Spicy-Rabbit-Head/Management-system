package com.zzk.service.sparePartsRelated.impl;

import com.zzk.dao.sparePartsRelated.DeviceSparePartsCostDao;
import com.zzk.entity.dto.sparePartsRelated.SparePartsInquiryDTO;
import com.zzk.entity.po.sparePartsManagement.DeviceSparePartsCost;
import com.zzk.service.imageRelated.ImageService;
import com.zzk.service.sparePartsRelated.SparePartsQueryService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 备品查询服务实现类<br>
 * <p>
 * <p>
 * 1.0版本：备品查询服务实现类构建<br>
 * <p>
 *
 * @author zhao'zi'kui
 * @version 1.0
 * @since 2024-01-26 14:11
 */
@Service
public class SparePartsQueryServiceImpl implements SparePartsQueryService {
    private final DeviceSparePartsCostDao deviceSparePartsCostDao;
    private final ImageService imageService;

    public SparePartsQueryServiceImpl(DeviceSparePartsCostDao deviceSparePartsCostDao, ImageService imageService) {
        this.deviceSparePartsCostDao = deviceSparePartsCostDao;
        this.imageService = imageService;
    }

    /**
     * 查询备品数据
     *
     * @param sparePartsInquiryDTO 备品查询数据传输对象
     */
    @Override
    public List<DeviceSparePartsCost> getSparePartsData(List<SparePartsInquiryDTO> sparePartsInquiryDTO) {
        List<DeviceSparePartsCost> deviceSparePartsCostList = new ArrayList<>();
        sparePartsInquiryDTO.forEach(sparePartsInquiry -> deviceSparePartsCostList.addAll(deviceSparePartsCostDao.selectDeviceSparePartsCostByDeviceNumber(sparePartsInquiry.getDeviceNumber(), sparePartsInquiry.getMaintenanceCycle())));
        // 合并
        Map<String, DeviceSparePartsCost> groupedBySparePart = deviceSparePartsCostList.stream()
                .collect(Collectors.toMap(
                        DeviceSparePartsCost::getSparePartName,
                        e -> e,
                        (e1, e2) -> {
                            e1.setQuantity(e1.getQuantity() + e2.getQuantity());
                            if (e1.getQuantity() != 0) {
                                try {
                                    e1.setTotalPrice(e1.getTotalPrice() + e2.getTotalPrice());
                                } catch (NullPointerException e) {
                                    e1.setTotalPrice(0F);
                                }
                            }
                            return e1;
                        }
                ));
        ArrayList<DeviceSparePartsCost> deviceSparePartsCosts = new ArrayList<>(groupedBySparePart.values());
        // 排序
        deviceSparePartsCosts.sort((o1, o2) -> {
            if (o1.getQuantity() > o2.getQuantity()) {
                return -1;
            } else if (o1.getQuantity().equals(o2.getQuantity())) {
                return 0;
            } else {
                return 1;
            }
        });

        // 设置图片
        deviceSparePartsCosts.forEach(deviceSparePartsCost -> deviceSparePartsCost.setImage(imageService.getImage(deviceSparePartsCost.getImage())));
        return deviceSparePartsCosts;
    }
}
