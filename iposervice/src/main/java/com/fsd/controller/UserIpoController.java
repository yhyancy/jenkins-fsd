package com.fsd.controller;

import com.fsd.data.entity.IpoEntity;
import com.fsd.data.mapper.IpoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "user/ipo")
public class UserIpoController {
    private IpoMapper ipoMapper;
    @Autowired
    private UserIpoController(IpoMapper ipoMapper){
        this.ipoMapper=ipoMapper;
    }

    @GetMapping("list")
    public List<IpoEntity> getIpoList(){
        return ipoMapper.listIpo();
    }

}
