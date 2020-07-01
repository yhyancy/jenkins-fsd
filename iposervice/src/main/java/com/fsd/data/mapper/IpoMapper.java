package com.fsd.data.mapper;

import com.fsd.data.entity.IpoEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import java.util.List;

@Mapper
@Repository
public interface IpoMapper {
    List<IpoEntity> listIpo();
    int addIpo(IpoEntity ipoEntity);
}
