package com.zzk.entrance.daoTexts;

import com.zzk.dao.permissionRelated.PermissionDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 权限集合数据库访问层测试<br>
 * <p>
 * <p>
 * 1.0版本：查询用户的权限集合<br>
 * <p>
 *
 * @author zhao'zi'kui
 * @version 1.0
 * @since 2023-05-18 10:34
 */
@SpringBootTest
public class PermissionDatTest {

    @Autowired
    public PermissionDao permissionDao;

    /**
     * 查询用户的菜单权限集合
     *
     * @apiNote 测试查询用户的菜单权限集合
     * @since 1.0
     */
    @Test
    void selectMenuPermissionsByUserId() {
        for (int i = 0; i < 10; i++) {
            System.out.println(permissionDao.selectMenuPermissionsByUserId(i));
        }
    }

    /**
     * 查询用户的操作权限集合
     *
     * @apiNote 测试查询用户的操作权限集合
     * @since 1.0
     */
    @Test
    void selectOperationPermissionsByUserId() {
        System.out.println(permissionDao.selectOperationPermissionsByUserId(1));
    }
}
