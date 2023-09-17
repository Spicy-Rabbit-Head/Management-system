package com.zzk.entity.permissions;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
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
    public UserDetails deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        // 解析Json
        JsonNode jsonNode = jsonParser.getCodec().readTree(jsonParser);
        // 构建用户信息
        UserData user = new UserData(jsonNode.get("id").asInt(), jsonNode.get("username").asText(), jsonNode.get("password").asText(), jsonNode.get("email").asText(), jsonNode.get("uuid").asText());
        // 获取权限信息
        JsonNode authorities = jsonNode.get("authorities");
        // 构建权限集合
        List<UserSimpleGrantedAuthority> authoritiesSet = new ArrayList<>(authorities.size());
        for (int i = 0; i < authorities.size(); i++) {
            authoritiesSet.add(new UserSimpleGrantedAuthority(authorities.get(i).get("authority").asText()));
        }
        // 建造用户数据详情
        return UserDataDetails.builder()
                .user(user)
                .authorities(authoritiesSet)
                .accountExpired(jsonNode.get("accountNonExpired").asBoolean())
                .accountLocked(jsonNode.get("accountNonLocked").asBoolean())
                .credentialsExpired(jsonNode.get("credentialsNonExpired").asBoolean())
                .disabled(jsonNode.get("enabled").asBoolean())
                .buildAll();
    }
}
