package com.fsd.data.entity.mutiCompare;

import com.fsd.data.entity.commonPriceReturn.PriceEntityReturn;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;

@Data
@AllArgsConstructor
public class MultiOutputEntity {
    private String name1;
    private String name2;
    List<PriceEntityReturn> price1;
    List<PriceEntityReturn> price2;
}
