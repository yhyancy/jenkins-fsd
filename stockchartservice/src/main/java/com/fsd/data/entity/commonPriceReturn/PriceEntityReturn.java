package com.fsd.data.entity.commonPriceReturn;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.sql.Timestamp;

public class PriceEntityReturn {
    private String price;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp time;
    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }
    public Timestamp getTime() {
        return time;
    }
    public void setTime(Timestamp time) {
        this.time = time;
    }
}
