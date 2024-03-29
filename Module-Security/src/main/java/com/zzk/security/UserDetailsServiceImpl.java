package com.zzk.security;

import com.zzk.dao.permissionRelated.PermissionDao;
import com.zzk.dao.userRelated.UserDataDao;
import com.zzk.entity.permissions.UserDataDetails;
import com.zzk.entity.po.userManagement.MenuPermission;
import com.zzk.entity.po.userManagement.OperationPermissions;
import com.zzk.entity.po.userManagement.UserData;
import com.zzk.utils.RedisSerializationUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
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
    private final static String USER_MENU = "_menu";
    private final static String USER_OPERATION = "_operation";

    // 用户数据访问对象
    private final UserDataDao userDataDao;
    // 用户权限数据访问对象
    private final PermissionDao permissionDao;

    // redis 序列化工具
    private final RedisSerializationUtils redisSerializationUtils;

    // 构造器注入
    public UserDetailsServiceImpl(UserDataDao userDataDao, PermissionDao permissionDao, RedisSerializationUtils redisSerializationUtils) {
        this.userDataDao = userDataDao;
        this.permissionDao = permissionDao;
        this.redisSerializationUtils = redisSerializationUtils;
    }

    /**
     * 根据用户名查询用户信息
     *
     * @param username 用户名
     *
     * @return UserDetails 用户信息
     *
     * @throws UsernameNotFoundException 用户名不存在异常
     * @since 1.0
     */
    @Override
    public UserDetails loadUserByUsername(String username) {
        // 查询用户信息
        UserData user = userDataDao.selectOne(username);
        // 如果用户不存在，抛出用户名不存在异常
        if (Objects.isNull(user)) {
            throw new UsernameNotFoundException("用户不存在");
        }
        // 如果用户存在,删除 redis 中的用户信息
        if (redisSerializationUtils.hasKey(user.getUuid())) {
            redisSerializationUtils.deleteString(user.getUuid());
        }
        var str = user.getUsername();
        // 如果 redis 中没有用户的权限信息，查询数据库并存入 redis
        if (!redisSerializationUtils.hasKey(str + USER_MENU)) {
            List<MenuPermission> menuPermissions = permissionDao.selectMenuPermissionsByUserId(user.getId());
            redisSerializationUtils.setString(str + USER_MENU, menuPermissions);
        }
        if (!redisSerializationUtils.hasKey(str + USER_OPERATION)) {
            List<OperationPermissions> operationPermissions = permissionDao.selectOperationPermissionsByUserId(user.getId());
            redisSerializationUtils.setString(str + USER_OPERATION, operationPermissions);
        }
        String role = permissionDao.selectRoleNameByUserId(user.getId());
        // 封装用户信息
        String uid = UUID.randomUUID().toString();
        user.setUuid(uid);
        userDataDao.updateUUID(user.getId(), uid);
        return UserDataDetails.builder()
                .user(user)
                .roles(role, redisSerializationUtils.getStringList(str + USER_OPERATION, OperationPermissions.class))
                .build();
    }
}
