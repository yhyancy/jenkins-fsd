package com.fsd.data.mapper;

import com.fsd.data.entity.CompanyEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CompanyMapper {
    int addCompany(CompanyEntity companyEntity);
    int updateCompany(CompanyEntity companyEntity);
    int disableCompany(CompanyEntity companyEntity);

    List<CompanyEntity> listCompany();
    CompanyEntity getCompanyByName(String companyName);
    CompanyEntity getCompanyByCode(String companyCode);

}
