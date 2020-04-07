package com.lsc.order.service;

import com.lsc.order.entity.Warehouse;

import java.util.List;

public interface WarehouseService {
    List<Warehouse> list(int sneakersId);

}
