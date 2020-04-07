package com.lsc.order.dao;

import com.lsc.order.entity.Sneakers;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SneakersMapper {
    List<Sneakers> listSneakers();
    Sneakers getSneakers(int sneakersId);

    void addSneakers(Sneakers sneakers);
    void upDateSneakers(Sneakers sneakers);
    void  deleteSneakers(int sneakersId);
}
