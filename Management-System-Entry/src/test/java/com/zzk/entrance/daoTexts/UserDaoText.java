package com.zzk.entrance.daoTexts;

import com.zzk.dao.UserPermissionsRelated.UserDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 用户表(User)表数据库访问层测试
 *
 * @author zhaozikui
 * @since 2023-03-09 20:13
 */
@SpringBootTest
public class UserDaoText {

    @Autowired
    public UserDao userDao;

    /**
     * 测试查询所有
     *
     * @return void
     */
    @Test
    void textList() {
        System.out.println("----- 测试查询所有开始 ------");
        userDao.selectList(null).forEach(System.out::println);
        System.out.println("----- 测试查询所有结束 ------");
    }
}
