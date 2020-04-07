package com.lsc.order.dao;

import com.lsc.order.entity.InputApply;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface OutputApplyMapper {
    void addInputApply(InputApply inputApply);
}
