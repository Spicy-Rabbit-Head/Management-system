package com.zzk.service.userRelated.impl;

import com.zzk.entity.permissions.UserDataDetails;
import com.zzk.entity.po.UserPermissionsRelated.MenuPermission;
import com.zzk.entity.response.R;
import com.zzk.service.userRelated.PermissionsService;
import com.zzk.utils.RedisSerializationUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class PermissionsServiceImpl implements PermissionsService {
    private final static String USER_MENU = "_menu";
    private final static String USER_OPERATION = "_operation";
    // Redis 序列化工具
    private final RedisSerializationUtils redisSerializationUtils;

    // 构造器注入 Redis 序列化工具
    public PermissionsServiceImpl(RedisSerializationUtils redisSerializationUtils) {
        this.redisSerializationUtils = redisSerializationUtils;
    }

    @Override
    public R getMenuList() {
        // 获取当前用户信息
        Authentication authenticationToken = SecurityContextHolder.getContext().getAuthentication();
        UserDataDetails principal = (UserDataDetails) authenticationToken.getPrincipal();
        // 查询 Redis 中的用户菜单
        return new R(233, "ok", true, redisSerializationUtils.getStringList(principal.getUsername() + USER_MENU, MenuPermission.class));
    }
}
