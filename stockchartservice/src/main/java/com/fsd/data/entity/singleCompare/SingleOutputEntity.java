package com.fsd.data.entity.singleCompare;

import com.fsd.data.entity.commonPriceReturn.PriceEntityReturn;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SingleOutputEntity {
    private String name;
    private List<PriceEntityReturn> price1;
    private List<PriceEntityReturn> price2;
}
