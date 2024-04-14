package com.warecase.mapper;

import com.warecase.pojo.User;

public interface UserMapper {

    User selectUserByUid(Integer uid);

}
