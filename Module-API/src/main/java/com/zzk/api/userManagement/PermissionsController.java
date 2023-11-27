package com.zzk.api.userManagement;

import com.zzk.entity.response.Response;
import com.zzk.entity.vo.permissionsRelated.MenuGroupVO;
import com.zzk.service.userRelated.PermissionsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 权限相关接口<br>
 * <p>
 * <p>
 * 1.0版本：权限相关接口构建<br>
 * <p>
 *
 * @author zhao'zi'kui
 * @version 1.0
 * @since 2023-09-21 09:33
 */
@RestController
@RequestMapping("/permissions")
public class PermissionsController {
    // 权限服务
    private final PermissionsService permissionsService;

    // 构造器注入权限服务
    public PermissionsController(PermissionsService permissionsService) {
        this.permissionsService = permissionsService;
    }

    /**
     * 获取菜单列表
     *
     * @return R 菜单列表
     *
     * @since 1.0
     */
    @GetMapping("/getMenuList")
    public Response<List<MenuGroupVO>> getMenuList() {
        return permissionsService.getMenuList();
    }
}
