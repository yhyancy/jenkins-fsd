package com.fsd.controller;

import com.fsd.data.entity.IpoEntity;
import com.fsd.data.entity.IpoReturn;
import com.fsd.data.mapper.IpoMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("admin/ipo")
public class AdminIpoController {

    private IpoMapper ipoMapper;
    private AdminIpoController(IpoMapper ipoMapper){
        this.ipoMapper=ipoMapper;
    }
    @GetMapping("list")
    private List<IpoEntity> getIpoList(){
        return ipoMapper.listIpo();
    }

    @PostMapping("add")
    private IpoReturn addIpo(@RequestBody(required = true) IpoEntity ipoEntity){
      int status= ipoMapper.addIpo(ipoEntity);
      if(status == 1){
          return new IpoReturn("OK");
      }
      return new IpoReturn("Failed");
    }
}
