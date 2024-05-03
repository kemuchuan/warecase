package com.warecase.pojo;

import com.warecase.core.pojo.BasePojo;
import lombok.Data;

/**
 * 实体类（User）
 */
@Data
public class User extends BasePojo {

    // 用户ID
    private String userId;
    // 用户名
    private String name;
    // 许可证
    private String permission;
    // 密码
    private String password;

}
