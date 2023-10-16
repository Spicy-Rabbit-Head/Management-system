package com.zzk.dao.userRelated;

import com.zzk.entity.po.userManagement.Member;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * 成员表(Member)表数据库访问层<br>
 * <p>
 * <p>
 * 1.0版本 ：2023-10-13 15:02<br>
 * 构建成员表(Member)表数据库访问层<br>
 * 实现基础的增删改查功能<br>
 * <p>
 *
 * @author zhao'zi'kui
 * @version 1.0
 * @since 2023-10-13 15:02
 */
@Repository
public interface MemberDao {
    /**
     * 查询所有成员
     *
     * @return 成员列表
     *
     * @apiNote 该方法查询所有成员
     * @since 1.0
     */
    @Select("SELECT * FROM user_management.member;")
    Member[] selectAll();
}
