package com.learn.service;


import com.learn.controller.dto.OrderDto;

public interface IOrderService {

    /**
     * 下单
     * @param orderDto
     * @return
     */
    String createOrder(OrderDto orderDto);
}
