package com.zzk.security;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zzk.dao.UserPermissionsRelated.UserDao;
import com.zzk.entity.permissions.LoginUser;
import com.zzk.entity.po.UserPermissionsRelated.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * 用户信息服务实现类<br>
 * <p>
 * <p>
 * 1.0版本：用户信息服务实现类构建<br>
 * <p>
 *
 * @author zhaozikui
 * @version 1.0
 * @since 2023-03-22 14:43
 */

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    // 用户数据访问对象
    private final UserDao userDao;

    // 构造器注入用户数据访问对象
    public UserDetailsServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    /**
     * 根据用户名查询用户信息
     *
     * @param username 用户名
     * @return UserDetails 用户信息
     * @throws UsernameNotFoundException 用户名不存在异常
     * @since 1.0
     */
    @Override
    public UserDetails loadUserByUsername(String username) {
        // 查询用户信息
        User user = userDao.selectOne(new QueryWrapper<User>().eq("username", username));
        // 如果用户不存在，抛出用户名不存在异常
        if (Objects.isNull(user)) {
            throw new UsernameNotFoundException("用户名不存在");
        }

        // TODO 查询对应的权限信息

        // 封装用户信息
        return new LoginUser(user);
    }
}
