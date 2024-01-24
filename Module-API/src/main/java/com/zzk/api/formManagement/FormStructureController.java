package com.zzk.api.formManagement;

import com.zzk.entity.response.Response;
import com.zzk.service.formRelated.FormStructureService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 表单结构相关接口<br>
 * <p>
 * <p>
 * 1.0版本：表单结构相关接口构建<br>
 * <p>
 *
 * @author zhao'zi'kui
 * @version 1.0
 * @since 2024-01-23 10:40
 */
@RestController
@RequestMapping("/formStructure")
public class FormStructureController {
    // 表单结构服务
    private final FormStructureService formStructureService;

    // 构造器注入表单结构服务
    public FormStructureController(FormStructureService formStructureService) {
        this.formStructureService = formStructureService;
    }

    /**
     * 获取表单结构
     *
     * @param formName 表单名称
     *
     * @return 表单结构
     */
    @RequestMapping("/getByFormName")
    public Response<String> getByFormName(String formName) {
        return Response.success(200, "获取表单结构成功", formStructureService.getByFormName(formName));
    }
}
