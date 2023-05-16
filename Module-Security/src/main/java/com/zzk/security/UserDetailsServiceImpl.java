package com.zzk.security;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zzk.dao.UserPermissionsRelated.UserDataDao;
import com.zzk.entity.permissions.UserDataDetails;
import com.zzk.entity.po.UserPermissionsRelated.UserData;
import com.zzk.utils.RedisSerializationUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.UUID;

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
    private final UserDataDao userDataDao;
    // redis 序列化工具
    private final RedisSerializationUtils redisSerializationUtils;

    // 构造器注入
    public UserDetailsServiceImpl(UserDataDao userDataDao, RedisSerializationUtils redisSerializationUtils) {
        this.userDataDao = userDataDao;
        this.redisSerializationUtils = redisSerializationUtils;
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
        UserData user = userDataDao.selectOne(new QueryWrapper<UserData>().eq("username", username));
        // 如果用户不存在，抛出用户名不存在异常
        if (Objects.isNull(user)) {
            throw new UsernameNotFoundException("用户不存在");
        }
        if (redisSerializationUtils.hasKey(user.getUuid())) {
            redisSerializationUtils.deleteString(user.getUuid());
        }
        // TODO 查询对应的权限信息

        // 封装用户信息
        String uid = UUID.randomUUID().toString();
        user.setUuid(uid);
        userDataDao.updateById(user);
        return UserDataDetails.builder()
                .user(user)
                .roles("USER", "ADMIN")
                .build();
    }
}
