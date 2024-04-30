package com.warecase.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.warecase.core.pojo.BasePojo;
import lombok.Data;

import java.util.Date;

@Data
public class StatisticsRepair extends BasePojo {


    private String name;
    private String serialId;
    private String returnId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date returnDate;

}
