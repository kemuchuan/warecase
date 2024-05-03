package com.warecase.util.permission;

import org.springframework.stereotype.Component;

@Component
public class PermissionService {

    public boolean hasPermission(String url,String permission) {
        return true;
    }

}
