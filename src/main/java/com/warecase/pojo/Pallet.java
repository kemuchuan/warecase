package com.warecase.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.warecase.core.pojo.BasePojo;
import lombok.Data;

import java.util.Date;

/**
 * 实体类（Pallet）
 */
@Data
public class Pallet extends BasePojo {

    private String palletid;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date returnDate;

    private String number;

    private String lorryid;
}
