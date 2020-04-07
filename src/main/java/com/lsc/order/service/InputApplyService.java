package com.lsc.order.service;

import com.github.pagehelper.PageInfo;
import com.lsc.order.entity.InputApply;

import java.util.List;
import java.util.Map;

public interface InputApplyService {
    PageInfo<InputApply> listInputApply(int pageNo, int pageSize,int applicantId,int code);

    void addInputApply(InputApply inputApply);

    Map yesInputApply(int pageNo, int pageSize);

    Map sumInputApply(int pageNo, int pageSize);

    void deleteInputApply(int inputApplyId);

    void updateInputStatus(Map map);


}
