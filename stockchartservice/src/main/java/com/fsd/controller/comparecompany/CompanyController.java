package com.fsd.controller.comparecompany;

import com.fsd.data.entity.commonPriceReturn.PriceEntityReturn;
import com.fsd.data.entity.mutiCompare.MultiInputEntity;
import com.fsd.data.entity.mutiCompare.MultiOutputEntity;
import com.fsd.data.entity.singleCompare.SingleInputEntity;
import com.fsd.data.entity.singleCompare.SingleOutputEntity;
import com.fsd.data.mapper.StockchartMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("compare/company")
@CrossOrigin("*")
public class CompanyController {
    private StockchartMapper stockchartMapper;
    public static final String TIME_FULL_SPRIT = "yyyy-MM-dd HH:mm:ss";

    @Autowired
    private CompanyController(StockchartMapper stockchartMapper) {
        this.stockchartMapper = stockchartMapper;
    }

    @PostMapping("single")
    public SingleOutputEntity getSingleCompanyPrices(@RequestBody(required = true) SingleInputEntity singleInputEntity) {
        singleInputEntity.setCode(stockchartMapper.getCompanyCode(singleInputEntity.getName()));
        return new SingleOutputEntity(singleInputEntity.getName(), stockchartMapper.getPrice1(singleInputEntity),
                stockchartMapper.getPrice2(singleInputEntity));
    }

    @GetMapping("multi")
    private MultiOutputEntity compareMutiCompany(@RequestBody(required = true) MultiInputEntity multiInputEntity) {

        multiInputEntity.setCode1(stockchartMapper.getCompanyCode(multiInputEntity.getName1()));
        multiInputEntity.setCode2(stockchartMapper.getCompanyCode(multiInputEntity.getName2()));

        List<PriceEntityReturn> mutiPrice1 = stockchartMapper.getMutiCompanyPrice1(multiInputEntity);
        List<PriceEntityReturn> mutiPrice2 = stockchartMapper.getMutiCompanyPrice2(multiInputEntity);

        return new MultiOutputEntity(multiInputEntity.getName1(), multiInputEntity.getName2(), mutiPrice1, mutiPrice2);
    }

}
