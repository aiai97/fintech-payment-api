package com.pay.payment_api.mapper;

import com.pay.payment_api.dto.CreateOrderRequest;
import com.pay.payment_api.dto.OrderResponse;
import com.pay.payment_api.entity.Order;

// isolate business transformation logic from controller and service layer, so that it can be reused in other places if needed
public class OrderMapper {

    public static Order toEntity(CreateOrderRequest request){

        Order order = new Order();

        order.setCustomerId(request.customerId());

        order.setAmount(request.amount());

        return order;
    }

    public static OrderResponse toResponse(Order order){

        return new OrderResponse(
                order.getId(),
                order.getCustomerId(),
                order.getAmount(),
                order.getStatus().name(),
                order.getCreatedAt()
        );
    }
}
