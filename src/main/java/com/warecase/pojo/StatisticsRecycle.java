package com.warecase.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.warecase.core.pojo.BasePojo;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class StatisticsRecycle extends BasePojo {

    private String name;
    private String serialId;
    private String returnId;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date recycleDate;

}
