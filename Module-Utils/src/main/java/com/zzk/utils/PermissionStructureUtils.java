package com.zzk.utils;

import com.zzk.entity.po.userPermissionsRelated.MenuPermission;
import com.zzk.entity.vo.MenuGroupVO;
import com.zzk.entity.vo.MenuVO;

import java.util.ArrayList;
import java.util.List;

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

    private PermissionStructureUtils() {
    }

    public static List<MenuGroupVO> convertToMenuGroups(List<MenuPermission> menuPermissions) {
        // 将菜单按照分组进行分类
        List<MenuGroupVO> menuGroupVOList = new ArrayList<>();

        // 遍历 MenuPermission 列表，按照分组将菜单归类
        for (MenuPermission permission : menuPermissions) {
            menuGroupVOList.add(new MenuGroupVO(permission.getGroupName(), convertToMenuVO(permission)));
        }

        System.out.println(menuGroupVOList);


        return null;
    }

    private static MenuVO[] convertToMenuVO(MenuPermission permission) {

        return null;
    }
}
