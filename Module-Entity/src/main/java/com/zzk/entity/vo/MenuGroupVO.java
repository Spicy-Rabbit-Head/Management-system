package com.zzk.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 用户菜单视图对象 <br>
 * <p>
 * <p>
 * 1.0版本：用户菜单视图对象构建<br>
 * <p>
 *
 * @author zhao'zi'kui
 * @version 1.0
 * @since 2023-10-03 10:26
 */
@Data
@AllArgsConstructor
public class MenuGroupVO {
    // 分组
    private String groupName;
    // 菜单项
    private MenuVO[] menus;
}
