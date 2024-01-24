package com.zzk.service.formRelated.impl;

import com.zzk.dao.formRelated.FormStructureDao;
import com.zzk.service.formRelated.FormStructureService;
import org.springframework.stereotype.Service;

/**
 * 表单结构相关服务接口实现类<br>
 * <p>
 * <p>
 * 1.0版本：表单结构相关服务接口实现类构建<br>
 * <p>
 *
 * @author zhao'zi'kui
 * @version 1.0
 * @since 2024-01-23 10:23
 */
@Service
public class FormStructureServiceImpl implements FormStructureService {
    /**
     * 表单结构表数据访问层
     */
    private final FormStructureDao formStructureDao;

    /**
     * 构造器注入
     *
     * @param formStructureDao 表单结构表数据访问层
     */
    public FormStructureServiceImpl(FormStructureDao formStructureDao) {
        this.formStructureDao = formStructureDao;
    }

    /**
     * 获取表单结构
     *
     * @param formName 表单名称
     *
     * @return 表单结构
     */
    @Override
    public String getByFormName(String formName) {
        return formStructureDao.selectByFormName(formName);
    }
}
