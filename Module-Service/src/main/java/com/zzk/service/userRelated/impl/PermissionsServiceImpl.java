package com.zzk.service.userRelated.impl;

import com.zzk.dao.permissionRelated.PermissionDao;
import com.zzk.entity.permissions.UserDataDetails;
import com.zzk.entity.po.userManagement.MenuPermission;
import com.zzk.entity.response.Response;
import com.zzk.entity.vo.permissionsRelated.MenuGroupVO;
import com.zzk.service.userRelated.PermissionsService;
import com.zzk.utils.PermissionStructureUtils;
import com.zzk.utils.RedisSerializationUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionsServiceImpl implements PermissionsService {
    private final static String USER_MENU = "_menu";
    private final static String USER_OPERATION = "_operation";
    // Redis 序列化工具
    private final RedisSerializationUtils redisSerializationUtils;
    // 权限菜单
    private final PermissionDao permissionDao;

    // 构造器注入 Redis 序列化工具
    public PermissionsServiceImpl(RedisSerializationUtils redisSerializationUtils, PermissionDao permissionDao) {
        this.redisSerializationUtils = redisSerializationUtils;
        this.permissionDao = permissionDao;
    }

    /**
     * 获取用户菜单
     *
     * @return Response 用户菜单
     */
    @Override
    public Response<List<MenuGroupVO>> getMenuList() {
        try {
            // 获取当前用户信息
            Authentication authenticationToken = SecurityContextHolder.getContext().getAuthentication();
            UserDataDetails principal = (UserDataDetails) authenticationToken.getPrincipal();
            // 查询 Redis 中的用户菜单
            List<MenuPermission> menuList = redisSerializationUtils.getStringList(principal.getUsername() + USER_MENU, MenuPermission.class);
            // 如果 Redis 中没有用户菜单，则从数据库中查询
            if (menuList == null) {
                menuList = permissionDao.selectMenuPermissionsByUserId(principal.getId());
                // 将用户菜单存入 Redis
                redisSerializationUtils.setString(principal.getUsername() + USER_MENU, menuList);
            }
            return Response.success(233, "ok", PermissionStructureUtils.convertToMenuGroups(menuList));
        } catch (Exception e) {
            e.printStackTrace();
            return Response.failed(500, "获取用户菜单失败", null);
        }
    }
}
