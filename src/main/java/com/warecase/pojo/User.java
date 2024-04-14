package com.warecase.pojo;

import com.warecase.core.pojo.BasePojo;
import lombok.Data;

@Data
public class User extends BasePojo {

    private Integer uid;
    private String uname;
    private String password;

}
