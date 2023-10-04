package com.zzk.entity.vo;

import com.zzk.entity.po.userPermissionsRelated.MenuPermission;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 菜单视图对象 <br>
 * <p>
 * <p>
 * 1.0版本：菜单视图对象构建<br>
 * <p>
 *
 * @author zhao'zi'kui
 * @version 1.0
 * @since 2023-10-03 11:50
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuVO {
    public MenuVO(MenuPermission menuPermission) {
        this.menuName = menuPermission.getMenuName();
        this.path = menuPermission.getPath();
        this.icon = menuPermission.getIcon();
        this.menuDesc = menuPermission.getMenuDesc();
    }

    // 菜单名
    private String menuName;
    // 地址
    private String path;
    // 图标
    private String icon;
    // 菜单描述
    private String menuDesc;
    // 子菜单
    private List<MenuVO> children;
}
