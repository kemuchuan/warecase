package com.warecase.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.warecase.core.pojo.BasePojo;
import lombok.Data;

import java.util.Date;

/**
 * 实体类（ReturnDetails）
 */
@Data
public class ReturnDetails extends BasePojo {


    private String returnId;
    private String userId;
    private String returnType;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date returnDate;
    private String serialId;
}
