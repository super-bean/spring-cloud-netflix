package com.learn.controller;


import com.learn.api.R;
import com.learn.controller.dto.OrderDto;
import com.learn.service.IOrderService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class OrderController {

    @Autowired
    IOrderService orderService;

    @PostMapping("/order")
    public R order(@RequestBody @Validated OrderDto orderDto, BindingResult bindingResult){
        orderDto.validData(bindingResult);
        String orderId=orderService.createOrder(orderDto);
        return new R.Builder<>().setData(orderId).buildOk();
    }
}
