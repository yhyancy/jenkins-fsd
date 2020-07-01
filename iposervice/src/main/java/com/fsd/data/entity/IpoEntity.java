package com.fsd.data.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class IpoEntity {
    private String id;
    private String company_name;
    private String stock_exchange;
    private String price_per_share;
    private int total_num;
    private Timestamp open_date_time;
    private String remark;
}
