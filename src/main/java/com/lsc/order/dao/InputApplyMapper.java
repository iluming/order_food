package com.lsc.order.dao;

import com.lsc.order.entity.InputApply;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface InputApplyMapper {
    List<InputApply> listInputApply(Map map);
    void addInputApply(InputApply inputApply);

    List<InputApply> yesInputApply(Map map);

    InputApply sumInputApply(Map map);

    void updateInputApply(InputApply inputApply);

    void deleteInputApply(int inputApplyId);

    void updateInputStatus(Map map);
}
