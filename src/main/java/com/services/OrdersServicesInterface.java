package com.services;

import com.models.Orders;
import com.models.Payment;

public interface OrdersServicesInterface {
    StringBuilder placeOrder(Orders payload);
    StringBuilder cancellOrder(Long id);
    StringBuilder makePayment(Payment payload);
}




























