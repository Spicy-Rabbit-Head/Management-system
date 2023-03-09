package com.zzk.entrance.daoTexts;

import com.zzk.dao.UserPermissionsRelated.UserDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserDaoText {

    @Autowired
    public UserDao userDao;

    @Test
    void textList() {
        userDao.selectList(null).forEach(System.out::println);
    }
}
