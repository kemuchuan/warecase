package com.warecase.pojo;

import com.warecase.core.pojo.BasePojo;
import lombok.Data;

/**
 * 实体类（Product）
 */
@Data
public class Product extends BasePojo {

    private String serialId;
    private String name;
    private String category;
    private String palletid;

}
