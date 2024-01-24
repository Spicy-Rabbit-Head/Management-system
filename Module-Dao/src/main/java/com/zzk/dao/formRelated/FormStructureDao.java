package com.zzk.dao.formRelated;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * 表单结构表(FormStructure)表数据库访问层<br>
 * <p>
 * <p>
 * 1.0版本：2024-01-23 10:26<br>
 * 构建表单结构相关数据访问层<br>
 * <p>
 *
 * @author zhao'zi'kui
 * @version 1.0
 * @since 2024-01-23 10:26
 */
@Repository
public interface FormStructureDao {
    /**
     * 按表单名称查询表单结构
     *
     * @param formName 表单名称
     *
     * @return 表单结构
     */
    @Select("SELECT form_content FROM form_management.form_structure WHERE form_name = #{formName}")
    String selectByFormName(String formName);
}
