package com.zzk.entity.permissions;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.zzk.entity.po.UserPermissionsRelated.UserData;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户信息详情反序列化器<br>
 * <p>
 * <p>
 * 1.0版本：用户信息详情反序列化器构建<br>
 * <p>
 *
 * @author zhao'zi'kui
 * @version 1.0
 * @since 2023-05-15 13:07
 */
public class UserDataDetailsDeserializer extends JsonDeserializer<UserDetails> {
    @Override
    public UserDetails deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
        // 解析Json
        TreeNode treeNode = jsonParser.getCodec().readTree(jsonParser);
        // 构建用户信息
        UserData user = new UserData(null, treeNode.get("username").toString(), treeNode.get("password").toString());
        // 获取权限信息
        TreeNode authorities = treeNode.get("authorities");
        // 构建权限集合
        List<UserSimpleGrantedAuthority> authoritiesSet = new ArrayList<>(authorities.size());
        for (int i = 0; i < authorities.size(); i++) {
            authoritiesSet.add(new UserSimpleGrantedAuthority(authorities.get(i).get("authority").toString()));
        }
        // 建造用户数据详情
        return UserDataDetails.builder()
                .user(user)
                .authorities(authoritiesSet)
                .accountExpired(Boolean.parseBoolean(treeNode.get("accountNonExpired").toString()))
                .accountLocked(Boolean.parseBoolean(treeNode.get("accountNonLocked").toString()))
                .credentialsExpired(Boolean.parseBoolean(treeNode.get("credentialsNonExpired").toString()))
                .disabled(Boolean.parseBoolean(treeNode.get("enabled").toString()))
                .buildAll();
    }
}
