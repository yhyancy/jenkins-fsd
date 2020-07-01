package com.fsd.controller.comparesector;

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
@RequestMapping("compare/sector")
@CrossOrigin("*")
public class SectorController {
    private StockchartMapper stockchartMapper;

    @Autowired
    private SectorController(StockchartMapper stockchartMapper) {
        this.stockchartMapper = stockchartMapper;
    }

    @PostMapping("single")
    public SingleOutputEntity conpareSingleSector(@RequestBody(required = true) SingleInputEntity sector) {

        List<PriceEntityReturn> price1 = stockchartMapper.getSingleSectorPrice(sector.getName(), sector.getStartTime1(), sector.getEndTime1());
        List<PriceEntityReturn> price2 = stockchartMapper.getSingleSectorPrice(sector.getName(), sector.getStartTime2(), sector.getEndTime2());
        return new SingleOutputEntity(sector.getName(), price1, price2);
    }

    @PostMapping("multi")
    public MultiOutputEntity compareMutiSector(@RequestBody(required = true) MultiInputEntity sectors){

        System.out.println(sectors.toString());
        List<PriceEntityReturn> price1 = stockchartMapper.getSingleSectorPrice(sectors.getName1(), sectors.getStartTime(), sectors.getEndTime());
        List<PriceEntityReturn> price2 = stockchartMapper.getSingleSectorPrice(sectors.getName2(), sectors.getStartTime(), sectors.getEndTime());
        return new MultiOutputEntity(sectors.getName1(), sectors.getName2(), price1, price2);
    }

}
