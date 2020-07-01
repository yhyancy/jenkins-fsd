package com.fsd.controller;

import com.fsd.data.entity.CompanyEntity;
import com.fsd.data.entity.CompanyReturn;
import com.fsd.data.mapper.CompanyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("admin/company")
public class ManagecompanyController {
    private CompanyMapper companyMapper;
    @Autowired
    private ManagecompanyController(CompanyMapper companyMapper){
        this.companyMapper=companyMapper;
    }

    @GetMapping("/list")
    public List<CompanyEntity> listCompany(){
       return companyMapper.listCompany();
    }

   @PostMapping("/add")
    public CompanyReturn addCompany(@RequestBody(required = true) CompanyEntity companyEntity){
        int status= companyMapper.addCompany(companyEntity);
        if(status == 1){
            return new CompanyReturn("ok");
        }
        return new CompanyReturn("failed");
   }

   @PostMapping("/update")
   public CompanyReturn updateComapany(@RequestBody(required = true) CompanyEntity companyEntity){
        int status = companyMapper.updateCompany(companyEntity);
        if(status == 1){
            return new CompanyReturn("ok");
        }
        return new CompanyReturn("failed");
   }

   @PostMapping("/disable")
    public CompanyReturn disableCompany(@RequestBody(required = true) CompanyEntity companyEntity){
        int status = companyMapper.disableCompany(companyEntity);
        if(status == 1){
            return new CompanyReturn("ok");
        }
       return new CompanyReturn("failed");
   }
}
