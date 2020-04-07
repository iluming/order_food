package com.lsc.order.service.imp;

import com.lsc.order.dao.KindMapper;
import com.lsc.order.entity.Kind;
import com.lsc.order.service.KindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KindServiceImp implements KindService {
    @Autowired
    KindMapper kindMapper;
    @Override
    public List<Kind> listKind() {
        return kindMapper.listKind();
    }
}
