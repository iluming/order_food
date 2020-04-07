package com.lsc.order.service;

import com.github.pagehelper.PageInfo;
import com.lsc.order.entity.Sneakers;

import java.util.List;

public interface SneakersService {
    PageInfo<Sneakers> listSneakers(int pageNo, int pageSize);

    List<Sneakers> listSneakers();

    Sneakers getSneaker(int sneakerId);

    void addSneakers(Sneakers sneakers);

    void upDateSneakers(Sneakers sneakers);

    void  deleteSneakers(int sneakersId);
}
