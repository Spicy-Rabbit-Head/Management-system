package com.zzk.service.imageRelated.impl;

import com.zzk.service.imageRelated.ImageService;
import org.springframework.stereotype.Service;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

@Service
public class ImageServiceImpl implements ImageService {
    /**
     * 查询图像
     *
     * @param imageName 图像名称
     */
    @Override
    public String getImage(String imageName) {
        try {
            byte[] image = Files.readAllBytes(Paths.get("D:/ServiceImage", imageName));
            return "data:image/jpeg;base64," + Base64.getEncoder().encodeToString(image);
        } catch (Exception ignored) {
            return null;
        }
    }
}
