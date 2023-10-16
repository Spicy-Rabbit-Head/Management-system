package com.zzk.utils;

import com.zzk.entity.po.userManagement.MenuPermission;
import com.zzk.entity.vo.permissionsRelated.MenuGroupVO;
import com.zzk.entity.vo.permissionsRelated.MenuVO;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 权限结构工具类 <br>
 * <p>
 * <p>
 * 1.0版本：权限结构工具类<br>
 * <p>
 *
 * @author zhao'zi'kui
 * @version 1.0
 * @since 2023-10-03 14:23
 */

public class PermissionStructureUtils {

    // 私有化构造器
    private PermissionStructureUtils() {
    }

    /**
     * 将 MenuPermission 列表转换为 MenuGroupVO 列表
     *
     * @param menuPermissions 菜单权限列表
     *
     * @return 菜单分组列表
     */
    public static List<MenuGroupVO> convertToMenuGroups(List<MenuPermission> menuPermissions) {
        // 将菜单按组分组
        Map<String, List<MenuPermission>> groupedMenus = menuPermissions.stream()
                .collect(Collectors.groupingBy(MenuPermission::getGroupName, LinkedHashMap::new, Collectors.toList()));

        // 构建 MenuGroupVO 列表
        List<MenuGroupVO> menuGroups = new ArrayList<>();
        groupedMenus.forEach((groupName, permissions) -> {
            List<MenuVO> menuVOs = convertToMenu(groupName, permissions);
            menuGroups.add(new MenuGroupVO(groupName, menuVOs));
        });

        return menuGroups;
    }

    /**
     * 将 MenuPermission 列表转换为 MenuVO 列表
     *
     * @param group       分组
     * @param permissions 菜单权限列表
     *
     * @return 菜单列表
     */
    private static List<MenuVO> convertToMenu(String group, List<MenuPermission> permissions) {
        List<MenuVO> menus = new ArrayList<>();
        // 获取顶级菜单
        List<MenuPermission> topLevelMenus = permissions.stream()
                .filter(permission -> permission.getGroupName().equals(group) && permission.getParentId() == 0).toList();

        // 构建顶级菜单
        topLevelMenus.forEach(menuPermission -> {
            MenuVO menuVO = new MenuVO(menuPermission);
            List<MenuVO> children = buildChildren(menuPermission.getId(), permissions);
            menuVO.setChildren(children);
            menus.add(menuVO);
        });

        return menus;
    }

    /**
     * 递归构建子菜单
     *
     * @param parentId    父菜单 ID
     * @param permissions 菜单权限列表
     *
     * @return 子菜单列表
     */
    private static List<MenuVO> buildChildren(int parentId, List<MenuPermission> permissions) {
        List<MenuVO> children = new ArrayList<>();
        // 获取子菜单
        List<MenuPermission> matchingPermissions = permissions.stream()
                .filter(permission -> permission.getParentId() == parentId).toList();
        if (matchingPermissions.isEmpty()) return null;

        matchingPermissions.forEach(menuPermission -> children.add(new MenuVO(menuPermission)));

        return children;
    }
}

