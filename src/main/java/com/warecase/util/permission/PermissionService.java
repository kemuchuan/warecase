package com.warecase.util.permission;

import org.springframework.stereotype.Component;

@Component
public class PermissionService {

    public boolean hasPermission(String url,String permission) {
        boolean flag = false;
        if("Manager of Operations".equals(permission)){
            // Manager of Operations can access all urls
            flag = true;
        }else if("Senior Logistics and Shipping Associate".equals(permission)){
            flag = !url.contains("user");
        }else if("Junior Logistics and Shipping Associate".equals(permission)){
            flag = url.endsWith("statistics");
        }
        return flag;
    }

}
