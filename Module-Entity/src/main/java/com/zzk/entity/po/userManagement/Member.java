package com.zzk.entity.po.userManagement;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * 成员表(com.zzk.entity.po.UserManagementRelated.Member)实体类<br>
 * <p>
 * <p>
 * 1.0版本 : 2023-10-13 14:58<br>
 * 成员表实体类构建<br>
 * <p>
 *
 * @author zhao'zi'kui
 * @version 1.0
 * @apiNote 该类是成员表实体类
 * @since 2023-10-13 14:58
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("user_management.member")
@ApiModel(description = "成员表", value = "Member")
public class Member extends Model<Member> {
    // 序列化
    @Serial
    private static final long serialVersionUID = 1L;

    // 成员名字
    @ApiModelProperty(value = "成员名称", name = "member_name")
    private String memberName;
}
