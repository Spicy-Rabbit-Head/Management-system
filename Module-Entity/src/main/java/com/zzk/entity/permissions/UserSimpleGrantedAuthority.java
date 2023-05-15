package com.zzk.entity.permissions;

import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.util.Assert;

/**
 * 授权的简单实现<br>
 * <p>
 * <p>
 * 1.0版本：授权的简单实现构建<br>
 * 存储授予Authentication对象的权限的字符串表示形式<br>
 * <p>
 *
 * @author zhao'zi'kui
 * @version 1.0
 * @since 2023-05-15 10:02
 */
@NoArgsConstructor
public final class UserSimpleGrantedAuthority implements GrantedAuthority {

    private String authority;

    public UserSimpleGrantedAuthority(String authority) {
        Assert.hasText(authority, "需要授权文本表示形式");
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return this.authority;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof UserSimpleGrantedAuthority) {
            return this.authority.equals(((UserSimpleGrantedAuthority) obj).authority);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.authority.hashCode();
    }

    @Override
    public String toString() {
        return this.authority;
    }
}
