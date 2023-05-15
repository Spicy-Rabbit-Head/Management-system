package com.zzk.entity.permissions;

import com.zzk.entity.po.UserPermissionsRelated.UserData;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.Assert;

import java.io.Serial;
import java.io.Serializable;
import java.util.*;

/**
 * 用户信息实体类<br>
 * 用于封装用户信息，实现 UserDetails 接口<br>
 * <p>
 * <p>
 * 1.0版本：用户信息实体类构建<br>
 * <p>
 *
 * @author zhaozikui
 * @version 1.0
 * @since 2023-03-10 17:00
 */
@Setter
@NoArgsConstructor
public class UserDataDetails implements UserDetails {
    // 用户信息
    private UserData user;
    // 权限信息
    private Set<GrantedAuthority> authorities;
    // 账户未过期
    private boolean accountNonExpired;
    // 账户未锁定
    private boolean accountNonLocked;
    // 凭证未过期
    private boolean credentialsNonExpired;
    // 账户可用
    private boolean enabled;

    // 构造
    public UserDataDetails(UserData user, Collection<? extends GrantedAuthority> authorities) {
        this(user, true, true, true, true, authorities);
    }

    // 构造
    public UserDataDetails(UserData user, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        Assert.isTrue(user.getUsername() != null && !"".equals(user.getUsername()) && user.getPassword() != null, "不能将 null 或 空值 传递给构造函数");
        this.user = user;
        this.enabled = enabled;
        this.accountNonExpired = accountNonExpired;
        this.credentialsNonExpired = credentialsNonExpired;
        this.accountNonLocked = accountNonLocked;
        this.authorities = Collections.unmodifiableSet(sortAuthorities(authorities));
    }

    // 排序权限信息
    private static SortedSet<GrantedAuthority> sortAuthorities(Collection<? extends GrantedAuthority> authorities) {
        Assert.notNull(authorities, "不能传递空的授权集合");
        SortedSet<GrantedAuthority> sortedAuthorities = new TreeSet<>(new UserDataDetails.AuthorityComparator());
        // 遍历授权集合
        for (GrantedAuthority grantedAuthority : authorities) {
            Assert.notNull(grantedAuthority, "授权集合不能包含任何空元素");
            sortedAuthorities.add(grantedAuthority);
        }
        // 返回排序后的授权集合
        return sortedAuthorities;
    }


    // 权限信息
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    // 获取密码
    @Override
    public String getPassword() {
        return user.getPassword();
    }

    // 获取用户名
    @Override
    public String getUsername() {
        return user.getUsername();
    }

    // 账户是否未过期
    // true：未过期 false：已过期
    @Override
    public boolean isAccountNonExpired() {
        return this.accountNonExpired;
    }

    // 账户是否未锁定
    // true：未锁定 false：已锁定
    @Override
    public boolean isAccountNonLocked() {
        return this.accountNonLocked;
    }

    // 凭证是否未过期
    // true：未过期 false：已过期
    @Override
    public boolean isCredentialsNonExpired() {
        return this.credentialsNonExpired;
    }

    // 账户是否可用
    // true：可用 false：不可用
    @Override
    public boolean isEnabled() {
        return this.enabled;
    }

    // 权限比较器
    private static class AuthorityComparator implements Comparator<GrantedAuthority>, Serializable {
        @Serial
        private static final long serialVersionUID = 600L;

        private AuthorityComparator() {
        }

        // 权限比较
        public int compare(GrantedAuthority g1, GrantedAuthority g2) {
            if (g2.getAuthority() == null) {
                return -1;
            } else {
                return g1.getAuthority() == null ? 1 : g1.getAuthority().compareTo(g2.getAuthority());
            }
        }
    }

    @Override
    public String toString() {
        return "UserDataDetails{" +
                "user=" + user +
                ", authorities=" + authorities +
                ", accountNonExpired=" + accountNonExpired +
                ", accountNonLocked=" + accountNonLocked +
                ", credentialsNonExpired=" + credentialsNonExpired +
                ", enabled=" + enabled +
                '}';
    }

    public static UserDataBuilder builder() {
        return new UserDataBuilder();
    }

    /**
     * 用户信息建造者<br>
     * <p>
     * <p>
     * 1.0版本：用户信息建造者构建<br>
     * <p>
     *
     * @author zhao'zi'kui
     * @version 1.0
     * @since 2023-05-14 20:40
     */
    public static final class UserDataBuilder {

        private UserData user;

        private List<GrantedAuthority> authorities;

        private boolean accountExpired;

        private boolean accountLocked;

        private boolean credentialsExpired;

        private boolean disabled;

        // 私有构造
        private UserDataBuilder() {
        }

        // 用户信息建造
        public UserDataBuilder user(UserData user) {
            Assert.notNull(user.getUsername(), "用户名不能为空");
            Assert.notNull(user.getPassword(), "密码不能为空");
            this.user = user;
            return this;
        }

        // 角色信息建造
        public UserDataBuilder roles(String... roles) {
            List<GrantedAuthority> authorities = new ArrayList<>(roles.length);
            for (String role : roles) {
                authorities.add(new SimpleGrantedAuthority("ROLE_" + role));
            }
            return authorities(authorities);
        }

        // 集合权限信息建造
        public UserDataBuilder authorities(Collection<? extends GrantedAuthority> authorities) {
            this.authorities = new ArrayList<>(authorities);
            return this;
        }

        // 账户是否过期建造
        public UserDataBuilder accountExpired(boolean accountExpired) {
            this.accountExpired = accountExpired;
            return this;
        }

        // 账户是否锁定建造
        public UserDataBuilder accountLocked(boolean accountLocked) {
            this.accountLocked = accountLocked;
            return this;
        }

        // 凭证是否过期建造
        public UserDataBuilder credentialsExpired(boolean credentialsExpired) {
            this.credentialsExpired = credentialsExpired;
            return this;
        }

        // 账户是否可用建造
        public UserDataBuilder disabled(boolean disabled) {
            this.disabled = disabled;
            return this;
        }

        // 部分建造
        public UserDetails build() {
            return new UserDataDetails(this.user, this.authorities);
        }

        // 全局建造
        public UserDetails buildAll() {
            return new UserDataDetails(this.user, !this.disabled, !this.accountExpired,
                    !this.credentialsExpired, !this.accountLocked, this.authorities);
        }
    }
}
