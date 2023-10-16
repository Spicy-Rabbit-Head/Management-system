package com.zzk.service.userRelated.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zzk.dao.userRelated.UserDataDao;
import com.zzk.entity.po.userManagement.UserData;
import com.zzk.service.userRelated.UserService;
import org.springframework.stereotype.Service;

/**
 * 用户服务实现类<br>
 * <p>
 * <p>
 * 1.0版本：用户服务实现类构建<br>
 * <p>
 *
 * @author zhao'zi'kui
 * @version 1.0
 * @apiNote 该类用于用户服务的实现
 * @since 2023-05-09 15:25
 */
@Service
public class UserServiceImpl implements UserService {
    // 用户数据访问对象
    private final UserDataDao userDao;

    // 构造器注入
    public UserServiceImpl(UserDataDao userDao) {
        this.userDao = userDao;
    }

    /**
     * 判断用户是否存在
     *
     * @param username 用户名
     * @return Boolean 用户是否存在
     * @since 1.0
     */
    @Override
    public Boolean whetherTheUserExists(String username) {
        return userDao.selectCount(new QueryWrapper<UserData>().eq("username", username)) > 0;
    }

    /**
     * 用户添加
     *
     * @param user 用户信息
     * @return Boolean 用户是否添加成功
     * @since 1.0
     */
    @Override
    public Boolean userAddition(UserData user) {
        return userDao.insert(user) > 0;
    }
}
