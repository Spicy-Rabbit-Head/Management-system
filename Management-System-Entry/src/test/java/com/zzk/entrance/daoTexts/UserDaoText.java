package com.zzk.entrance.daoTexts;

import com.zzk.dao.UserPermissionsRelated.UserDao;
import com.zzk.entity.po.UserPermissionsRelated.User;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * 用户表(User)表数据库访问层测试<br>
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
public class UserDaoText {

    @Autowired
    public UserDao userDao;

    private static Integer id;

    /**
     * 测试插入
     *
     * @return void
     * @since 1.0
     */
    @Test
    @Order(1)
    void textInsert() {
        System.out.println("----- 测试插入开始 ------");
        int insert = userDao.insert(new User(null, "test", "test"));
        System.out.println("影响:" + insert);
        System.out.println("----- 测试插入结束 ------");
    }

    /**
     * 测试查询所有
     *
     * @return void
     * @since 1.0
     */
    @Test
    @Order(2)
    void textList() {
        System.out.println("----- 测试查询所有开始 ------");
        List<User> users = userDao.selectList(null);
        users.forEach(System.out::println);
        id = users.get(users.size() - 1).getId();
        System.out.println("----- 测试查询所有结束 ------");
    }

    /**
     * 测试更新
     *
     * @return void
     * @since 1.0
     */
    @Test
    @Order(3)
    void textUpdateById() {
        System.out.println("----- 测试更新开始 ------");
        User user = new User(id, "testUpdate", "testUpdate");
        int i = userDao.updateById(user);
        System.out.println("影响:" + i);
        System.out.println("----- 测试更新结束 ------");
    }

    /**
     * 测试查询单个
     *
     * @return void
     * @since 1.0
     */
    @Test
    @Order(4)
    void textGetById() {
        System.out.println("----- 测试查询单个开始 ------");
        User user = userDao.selectById(id);
        System.out.println(user);
        System.out.println("----- 测试查询单个结束 ------");
    }

    /**
     * 测试删除
     *
     * @return void
     * @since 1.0
     */
    @Test
    @Order(5)
    void textDeleteById() {
        System.out.println("----- 测试删除开始 ------");
        int i = userDao.deleteById(id);
        System.out.println("影响:" + i);
        System.out.println("----- 测试删除结束 ------");
    }
}
