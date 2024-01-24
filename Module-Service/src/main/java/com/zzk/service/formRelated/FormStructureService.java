package com.zzk.service.formRelated;

/**
 * 表单结构相关服务接口<br>
 * <p>
 * <p>
 * 1.0版本：表单结构相关服务接口构建<br>
 * <p>
 *
 * @author zhao'zi'kui
 * @version 1.0
 * @since 2024-01-23 10:21
 */
public interface FormStructureService {
    /**
     * 获取表单结构
     *
     * @param formName 表单名称
     *
     * @return 表单结构
     */
    String getByFormName(String formName);
}
