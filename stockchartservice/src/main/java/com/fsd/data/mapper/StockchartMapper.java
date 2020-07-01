package com.fsd.data.mapper;

import com.fsd.data.entity.mutiCompare.MultiInputEntity;
import com.fsd.data.entity.singleCompare.SingleInputEntity;
import com.fsd.data.entity.commonPriceReturn.PriceEntityReturn;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import java.util.List;

@Mapper
@Repository
public interface StockchartMapper {

    String getCompanyCode(String companyName);

    // single company compare
    List<PriceEntityReturn> getPrice1(SingleInputEntity singleInputEntity);
    List<PriceEntityReturn> getPrice2(SingleInputEntity singleInputEntity);
    List<PriceEntityReturn> getSingleCompanyPrice(String code, String start, String end);

    // Muti company compare
    List<PriceEntityReturn> getMutiCompanyPrice1(MultiInputEntity multiInputEntity);
    List<PriceEntityReturn> getMutiCompanyPrice2(MultiInputEntity multiInputEntity);

    // Single Sector Compare
    // get times
    List<PriceEntityReturn> getSingleSectorPrice(String name, String start, String end);
}
