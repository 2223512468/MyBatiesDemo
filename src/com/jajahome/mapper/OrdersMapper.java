package com.jajahome.mapper;

import com.jajahome.po.OrdersCustom;

import java.util.List;

public interface OrdersMapper {
    public List<OrdersCustom> findOrderUserList() throws Exception;
}
