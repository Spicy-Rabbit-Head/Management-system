package com.zzk.utils;

import com.zzk.entity.po.userPermissionsRelated.MenuPermission;
import com.zzk.entity.vo.MenuGroupVO;
import com.zzk.entity.vo.MenuVO;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

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
     * @return 菜单分组列表
     */
    public static List<MenuGroupVO> convertToMenuGroups(List<MenuPermission> menuPermissions) {
        // 将菜单按照分组进行分类
        Map<String, List<MenuVO>> menuVOMap = new LinkedHashMap<>();

        // 遍历 MenuPermission 列表，按照分组将菜单归类
        for (MenuPermission permission : menuPermissions) {
            String groupName = permission.getGroupName();
            menuVOMap.computeIfAbsent(groupName, k -> convertToMenuVO(groupName, menuPermissions));
        }

        // 将 Map 转换为 List
        ArrayList<MenuGroupVO> menuGroupVOS = new ArrayList<>();
        menuVOMap.forEach((k, v) -> menuGroupVOS.add(new MenuGroupVO(k, v)));

        for (MenuGroupVO menuGroupVO : menuGroupVOS) {
            System.out.println(menuGroupVO);
        }

        return menuGroupVOS;
    }

    /**
     * 将 MenuPermission 列表转换为 MenuVO 列表
     *
     * @param group       分组
     * @param permissions 菜单权限列表
     * @return 菜单列表
     */
    private static List<MenuVO> convertToMenuVO(String group, List<MenuPermission> permissions) {
        ArrayList<MenuVO> menuVOS = new ArrayList<>();
        AtomicReference<Integer> parentId = new AtomicReference<>(0);
        permissions.forEach(p -> {
            if (p.getGroupName().equals(group) && p.getParentId() == 0) {
                menuVOS.add(new MenuVO(p));
                parentId.set(p.getId());
            }
            if (parentId.get() != 0 && Objects.equals(p.getParentId(), parentId.get())) {
                if (menuVOS.get(0).getChildren() == null) {
                    menuVOS.get(0).setChildren(new ArrayList<>());
                    menuVOS.get(0).getChildren().add(new MenuVO(p));
                } else menuVOS.get(0).getChildren().add(new MenuVO(p));
            }
        });

        return menuVOS;
    }
}
