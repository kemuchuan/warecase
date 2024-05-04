package com.warecase.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 实体类（ReturnDetails）
 */
@Data
public class ReturnDetails {


    private String returnId;
    private String userId;
    private String returnType;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date returnDate;
    private String serialId;
}
