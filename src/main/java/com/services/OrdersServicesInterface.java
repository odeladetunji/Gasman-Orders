package com.services;

import com.models.Orders;

public interface OrdersServicesInterface {
    StringBuilder placeOrder(Orders payload);
}
