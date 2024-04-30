package com.warecase.pojo;

import com.warecase.core.pojo.BasePojo;
import lombok.Data;

@Data
public class Statistics extends BasePojo {

    private String name;

    private String totalreturned;

    private String totalrepair;

    private String totalrefund;

    private String totalrecycle;

}
