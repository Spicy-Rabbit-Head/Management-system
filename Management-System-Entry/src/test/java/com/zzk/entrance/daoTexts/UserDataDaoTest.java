package com.zzk.entrance.daoTexts;

import com.zzk.dao.UserPermissionsRelated.UserDataDao;
import com.zzk.entity.po.userPermissionsRelated.UserData;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;


/**
 * 用户表(com.zzk.entity.po.UserPermissionsRelated.UserData)表数据库访问层测试<br>
 * <p>
 * <p>
 * 1.0版本：测试CRUD基本操作<br>
 * <p>
 *
 * @author zhaozikui
 * @version 1.0
 * @since 2023-03-09 20:13
 */
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserDataDaoTest {
    // 用户表(UserData)表数据库访问层
    @Autowired
    public UserDataDao userDao;

    // 密码编码器
    @Autowired
    private PasswordEncoder passwordEncoder;

    // 测试用户id
    private static Integer id;

    /**
     * 测试插入
     *
     * @apiNote 测试插入数据
     * @since 1.0
     */
    @Test
    @Order(1)
    void insert() {
        System.out.println("----- 测试插入开始 ------");
        int insert = userDao.insert(new UserData(null, "test1", passwordEncoder.encode("123123"), null, null));
        System.out.println("影响:" + insert);
        System.out.println("----- 测试插入结束 ------");
    }

    /**
     * 测试查询所有
     *
     * @apiNote 测试查询所有数据
     * @since 1.0
     */
    @Test
    @Order(2)
    void getList() {
        System.out.println("----- 测试查询所有开始 ------");
        List<UserData> users = userDao.selectList(null);
        users.forEach(System.out::println);
        id = users.get(users.size() - 1).getId();
        System.out.println("----- 测试查询所有结束 ------");
    }

    /**
     * 测试更新
     *
     * @apiNote 测试按id更新数据
     * @since 1.0
     */
    @Test
    @Order(3)
    void updateById() {
        System.out.println("----- 测试更新开始 ------");
        if (id == null) {
            getList();
        }
        UserData user = new UserData(id, "test1", passwordEncoder.encode("123456"), null, null);
        int i = userDao.updateById(user);
        System.out.println("影响:" + i);
        System.out.println("----- 测试更新结束 ------");
    }

    /**
     * 测试查询单个
     *
     * @apiNote 测试按id查询单个数据
     * @since 1.0
     */
    @Test
    @Order(4)
    void getById() {
        System.out.println("----- 测试查询单个开始 ------");
        if (id == null) {
            getList();
        }
        UserData user = userDao.selectById(id);
        System.out.println(user);
        System.out.println("----- 测试查询单个结束 ------");
    }

    /**
     * 测试删除
     *
     * @apiNote 测试按id删除数据
     * @since 1.0
     */
    @Test
    @Order(5)
    void deleteById() {
        System.out.println("----- 测试删除开始 ------");
        if (id == null) {
            getList();
        }
        int i = userDao.deleteById(id);
        System.out.println("影响:" + i);
        System.out.println("----- 测试删除结束 ------");
    }
}
